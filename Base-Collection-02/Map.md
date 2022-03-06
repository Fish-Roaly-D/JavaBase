## Map

#### HashMap分析

##### 简介

`HashMap `主要用来存放键值对，它基于哈希表的 `Map` 接口实现，是常用的 Java 集合之一，是非线程安全的。

`HashMap` 可以存储 null 的 key 和 value，但 `null` 作为键只能有一个，`null` 作为值可以有多个

JDK1.8 之前 `HashMap` 由 数组+链表 组成的，数组是 `HashMap` 的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）。 JDK1.8 以后的 `HashMap` 在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间。

`HashMap` 默认的初始化大小为 16。之后每次扩充，容量变为原来的 2 倍。并且， `HashMap` 总是使用 2 的幂作为哈希表的大小。



##### 属性

```java
// 序列号
private static final long serialVersionUID = 362498820763181265L;
// 默认的初始容量是16
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;
// 最大容量
static final int MAXIMUM_CAPACITY = 1 << 30;
// 默认的加载因子
static final float DEFAULT_LOAD_FACTOR = 0.75f;
// 当桶(bucket)上的结点数大于这个值时会转成红黑树
static final int TREEIFY_THRESHOLD = 8;
// 当桶(bucket)上的结点数小于这个值时树转链表
static final int UNTREEIFY_THRESHOLD = 6;
// 桶中结构转化为红黑树对应的table的最小容量
static final int MIN_TREEIFY_CAPACITY = 64;
// 存储元素的数组，长度总是2的幂次倍
transient Node<k,v>[] table;
// 存放具体元素的集
transient Set<map.entry<k,v>> entrySet;
// 存放元素的个数，注意这个不等于数组的长度。
transient int size;
// 模数，每次扩容和更改map结构的计数器
transient int modCount;
// 临界值(容量*加载因子) 当实际大小超过临界值时，会进行扩容
int threshold;
// 加载因子
final float loadFactor;
```



##### Node.class

> 数组是`hashMap`的主体，数组中存的是一个个`Node`节点(Entry的实现类)。
>
> `key-value`键值对
>
> `hash`值，`HashMap`中通过扰动函数`hash()`方法计算所得，减少哈希冲突。

> 哈希值用于快速得到对象地址的值，从而判断对象是否重复的一种方法。哈希冲突是指不同的对象得到相同的哈希值的现象。

```java
static class Node<K,V> implements Map.Entry<K,V> {
    final int hash;
    final K key;
    V value;
    Node<K,V> next;

    Node(int hash, K key, V value, Node<K,V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
```



##### jdk1.7提供的indexFor()方法

> 根据`key`的哈希值和`table`数组长度来得到元素下标的方法

> 首先`table`数组的长度永远是2的幂次方。`HashMap`中`Node`节点在数组中的位置是基于`key`的哈希值判断的。`hash`值是可以确认一个对象（也就是`key`值），且`hash()`扰动函数将`hash`值的高位与地位特征通过异或运算结合到了低16位。

用哈希值除数组容量取余，得到的整数，随机分配到数组中。这也是散列的特征。而取模运算的效率远远低于位运算。

为何`length`要减一？

`HashMap`中数组的长度都是2的幂次方，也就是  1XXX XXXX XXXX XXXX。

减一  =>  0111 1111 1111 1111   这样与运算得到结果就是哈希值的低位数值。且不会出现数组越界的情况。



举例：一个32位的经过扰动哈数扰动的哈希值。数组长度为32 (2^5)

哈希值：	1010	1100	0101	1010	1100	1101	0001	0110		

length：	0000	0000	0000	0000	0000	0000	0010	0000		32

length-1:    0000	0000	0000	0000	0000	0000	0001	1111		31

按位与：    0000	0000	0000	0000	0000	0000	0001	0110		22

结果：22。该`Node`节点存入`table`下标为22的位置。

```java
static int indexFor(int h, int length) {
    return h & (length-1);
}
```



##### hash()方法

> 也叫扰动函数。`key`的哈希值，右移16位(低位变高位，高位0填充)与原哈希值异或。（即保存了高位也保留了低位特征）
>
> 解决哈希冲突，加快查询效率。

为何需要哈希扰动？

将原哈希值的高位与低位的特征全部都保留在低位，哈希值的低位（低16位）是节点下标的依据。

防止出现两个不同的`key`值生成的哈希值，高位不同，低位相似。

举例：

假设两个`key`的哈希值为，数组长度`length`为16（2^4）

|                    | key1                                           | key2                                           |
| ------------------ | ---------------------------------------------- | ---------------------------------------------- |
| 原hash值           | 1010  1100  0101  1010  1100  1101  0001  0110 | 0010  1110  0111  0010  1100  1101  0001  0110 |
| 不扰动直接得到下标 | 0110                                           | 0110                                           |

> 这种情况的出现和糟糕的哈希算法有关。
>
> 现象：不同的`key`，却出现哈希碰撞（在HashMap中）
>
> 原因：计算下标单单结合哈希值的低位，未结合高位
>
> 解决：将哈希值低位和高位的特征结合，也就是进行哈希扰动

同样地：

|                       | key1                                           | key2                                           |
| --------------------- | ---------------------------------------------- | ---------------------------------------------- |
| 原hash值              | 1010  1100  0101  1010  1100  1101  0001  0110 | 0010  1110  0111  0010  1100  1101  0001  0110 |
| 右移16位（高位0填充） | 0000  0000  0000  0000  1010  1100  0101  1010 | 0000  0000  0000  0000  0010  1110  0111  0010 |
| 与原hash异或          | 1010  1100  0101  1010  0110  0001  0100  1100 | 0010  1110  0111  1010  1110  0111  0110  0100 |
| 得到下标              | 1100（12）                                     | 0100（4）                                      |

> 经过扰动函数，原来会出现哈希冲突的两个`key`值，得到的下标（index）值不一样了，也就避免了哈希冲突。

```java
static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
}
```

##### 构造方法

```java
public HashMap(int initialCapacity, float loadFactor) {
    this.loadFactor = loadFactor;
    //tableSizeFor方法返回一个2的幂次数，是数组容量，而不是临界值（在数组初次扩容时会修改为0.75X）
    this.threshold = tableSizeFor(initialCapacity);
}

public HashMap(int initialCapacity) {
    //16  0.75f
    this(initialCapacity, DEFAULT_LOAD_FACTOR);
}

public HashMap() {
    //0.75
    //首次扩容，初始化默认容量16
    this.loadFactor = DEFAULT_LOAD_FACTOR; 
}

public HashMap(Map<? extends K, ? extends V> m) {
    this.loadFactor = DEFAULT_LOAD_FACTOR;
    putMapEntries(m, false);
}
```



##### tableSizeFor

> 为何会返回一个2的幂次方整型数。也就是`table`数组的长度。

***<u>2的幂次方数字特征：</u>***

2 4 8 

0010		0100	1000

最高位的有效位为1，其余都是0（不考虑负数）

***<u>我们需要做的：</u>***

将传入的值`initialCapacity`转换为比他大的最近的2的幂次数。

25 -> 32  15 -> 16

***<u>java代码实现：</u>***

```java
@Test
public void tableSizeForTest() {
    int i = tableSizeForTest(33);// 64
    System.out.println(i);
}
public static int tableSizeForTest(int n){
    //对自然数e求对数。结合换底公式
    double m = Math.log(n) / Math.log(2);
    //没有小数返回，有小数向上进一
    int m2 = (int) Math.ceil(m);
    //2的m2幂次方
    return (int) Math.pow(2, m2);
}
```

***<u>`HashMap`实现：</u>***

```java
static final int tableSizeFor(int cap) {
    int n = cap - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
}
```

原理：

将任意十进制的整数，转化为比本身大且最近的二次幂数，结果是这个数本身二进制表示法的**最高有效位的前一位变成1，最高有效位以及其后的位都变为0**。

也就是**最高有效位的前一位变成1，最高有效位以及其后的位都变为1**，再加1。

> 右移1位或运算：有2位变为1
>
> 右移2位或运算：有4位变为1
>
> 右移4位或运算：有8位变为1
>
> 右移8位或运算：有16位变为1
>
> 右移16位或运算：保证最高有效位之后都变为1
>
> int一共32位  最后加一就是2的幂次数

举例  0001xxxx   xxxxxxxx  xxxxxxxx  xxxxxxxx (x为0或1)

|                | 33                                                    | 与运算                                                       |
| -------------- | ----------------------------------------------------- | ------------------------------------------------------------ |
| 原二进制       | 000==1==xxxx   xxxxxxxx  xxxxxxxx  xxxxxxxx           | \                                                            |
| 右移1位或运算  | 0000==1==xxx   xxxxxxxx  xxxxxxxx  xxxxxxxx           | 000==11==xxx   xxxxxxxx  xxxxxxxx  xxxxxxxx                  |
| 右移2位或运算  | 00000==11==x   xxxxxxxx  xxxxxxxx  xxxxxxxx           | 000==1111==x   xxxxxxxx  xxxxxxxx  xxxxxxxx                  |
| 右移4位或运算  | 0000000==1==  ==111==xxxxx  xxxxxxxx  xxxxxxxx        | 000==11111==   ==111==xxxxx  xxxxxxxx  xxxxxxxx              |
| 右移8位或运算  | 00000000  000==11111==   ==111==xxxxx  xxxxxxxx       | 000==11111==   ==111====11111==   ==111==xxxxx  xxxxxxxx     |
| 右移16位或运算 | 00000000 00000000  ==111====11111==  ==111====11111== | 000==11111==   ==111====11111==   ==11111111==  ==111====11111== |
| 加一           | 00100000  00000000 00000000 00000000                  | \                                                            |



##### put()方法

> `put`方法会调用`putVal`方法，而`putVal`方法不会提供给用户使用

```java
public V put(K key, V value) {
    return putVal(hash(key), key, value, false, true);
}
```

> 参数简单说明:看注解就行
>
> `hash`:`int`类型的哈希值（经过`hash`扰动的整数类型）
>
> K V   `key`和`value`
>
> `onlyIfAbsent:   if true, don't change existing value` 
>
> `evict:         if false, the table is in creation mode`

```java
final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
               boolean evict) {
    Node<K,V>[] tab; Node<K,V> p; int n, i;
    //初始化tab。如果table为空（table没有初始化、首次put值），进行table扩容
    //初始化n（为table数组长度，两种情况：1、默认容量16 2、自定义初始化容量 比initCapacity大的最近的二进制整数）
    if ((tab = table) == null || (n = tab.length) == 0)
        n = (tab = resize()).length;
    //如果该位置没有值（node节点也叫entry节点），直接在该位置放入值
    //上文也介绍过jdk1.7是如何将节点散列的放入table数组
    if ((p = tab[i = (n - 1) & hash]) == null)
        tab[i] = newNode(hash, key, value, null);
    //如果该位置有值：1、覆盖  2、哈希冲突，拉链法
    else {
        Node<K,V> e; K k;
        //key值完全相同（hash值&对象完全相同）
        //直接覆盖Node节点value值
        if (p.hash == hash &&
            ((k = p.key) == key || (key != null && key.equals(k))))
            e = p;
        //如果该节点是红黑树节点
        else if (p instanceof TreeNode)
            e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
        //！（p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))）
        //key的hash值或者key对象不同。=》key对象相同那么hash值一定相同，所以说只有两种情况 
        //①出现了哈希冲突  ②key对象的hash值低位相同  在hashmap中统一定义为哈希冲突
        else {
            for (int binCount = 0; ; ++binCount) {
                //如果p节点没有next，则在p后添加一个节点，并跳出循环
                if ((e = p.next) == null) {
                    p.next = newNode(hash, key, value, null);
                    //当链表长度大于8时转换为红黑树
                    if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
                        treeifyBin(tab, hash);
                    break;
                }
                //如果在以e为链表头的链表上找到了和需要添加进来的key值完全相同的节点的key，跳出循环,并覆盖相同节点value值
                if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                    break;
                p = e;
            }
        }
        //当有节点key值重复覆盖value值（包括table数组和链表上的节点）
        if (e != null) { // existing mapping for key
            V oldValue = e.value;
            if (!onlyIfAbsent || oldValue == null)
                e.value = value;
            afterNodeAccess(e);
            return oldValue;
        }
    }
    ++modCount;
    if (++size > threshold)
        resize();
    afterNodeInsertion(evict);
    return null;
}
```

##### resize()扩容方法

> ①`table`为`null`没有初始化，且`threshold`为0（有参构造，初始化的capacity放置在threshold）
>
> ②`table`为`null`没有初始化，且`threshold`不为0（有参构造，初始化的capacity放置在threshold）
>
> ③`table`初始化了

```java
final Node<K,V>[] resize() {
    Node<K,V>[] oldTab = table;
    int oldCap = (oldTab == null) ? 0 : oldTab.length;
    int oldThr = threshold;
    int newCap, newThr = 0;
    //table初始化过了
    if (oldCap > 0) {
        //无法扩容，不管哈希冲突了
        if (oldCap >= MAXIMUM_CAPACITY) {
            threshold = Integer.MAX_VALUE;
            return oldTab;
        }
        //否则  容量和临界值 都扩容两倍
        else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                 oldCap >= DEFAULT_INITIAL_CAPACITY)
            newThr = oldThr << 1; // double threshold
    }
    //table没有初始化，且threshold被赋值
    //创建HashMap实例，赋予初始化容量时，初始化容量放置在threshold（临界值）中
    else if (oldThr > 0) // initial capacity was placed in threshold
        newCap = oldThr;
    //table没有初始化，且threshold没赋值  也就是无参构造
    //使用默认初始化容量和默认加载因子
    else {               // zero initial threshold signifies using defaults
        newCap = DEFAULT_INITIAL_CAPACITY;
        newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
    }
    //table没有初始化，且threshold被赋值，乘加载因子（默认0.75）
    if (newThr == 0) {
        float ft = (float)newCap * loadFactor;
        newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                  (int)ft : Integer.MAX_VALUE);
    }
    //更新临界值
    threshold = newThr;
    @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
    //更新table
    table = newTab;
    //table被初始化
    if (oldTab != null) {
        for (int j = 0; j < oldCap; ++j) {
            Node<K,V> e;
            //当前节点不为空
            if ((e = oldTab[j]) != null) {
                //设为null方便GC回收
                oldTab[j] = null;
                //当前节点没有next（也就是这个节点没有hash冲突）  直接将当前节点放入newTable
                if (e.next == null)
                    newTab[e.hash & (newCap - 1)] = e;
                //如果当前节点是红黑树节点
                else if (e instanceof TreeNode)
                    ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                //当前节点是链表节点（链表的head节点）
                else { // preserve order
                    //lo  low低的意思  hi  high高的意思
                    //数组高位和低位的头尾节点
                    Node<K,V> loHead = null, loTail = null;
                    Node<K,V> hiHead = null, hiTail = null;
                    Node<K,V> next;
                    //这里做了将链表进行平衡的操作
                    do {
                        next = e.next;    
                        //下文举例说明
                        if ((e.hash & oldCap) == 0) {
                            if (loTail == null)
                                loHead = e;
                            else
                                loTail.next = e;
                            loTail = e;
                        }
                        else {
                            if (hiTail == null)
                                hiHead = e;
                            else
                                hiTail.next = e;
                            hiTail = e;
                        }
                    } while ((e = next) != null);
                    //将尾结点的下一个节点设为null
                    if (loTail != null) {
                        loTail.next = null;
                        newTab[j] = loHead;
                    }
                    if (hiTail != null) {
                        hiTail.next = null;
                        newTab[j + oldCap] = hiHead;
                    }
                }
            }
        }
    }
    return newTab;
}
```



> 整个扩容操作分为三种情况：
>
> ①数组为null，没有给threshold赋值
>
> 数组容量（capacity）为默认初始化容量  16，临界值（threshold）为0.75*16  12。初始化数组
>
> ②数组为null，给threshold赋值（加载因子不重要，0.75为官方提供的空间利用率和效率较高的）
>
> 源码注释也有说明，初始化的容量被放置在临界值中。
>
> 数组容量为tableSizeFor方法返回的（也就是threshold），更新threshold（数组容量*加载因子【loadFactor】），初始化数组
>
> ③数组为不为null
>
> 数组容量左移一位（两倍），临界值左移一位（两倍）。将旧数组节点，放入新数组节点。

`e.hash & oldCap`表达式的作用，如何通过他进行对链表平衡。

> 我们知道对于底层实现是数组的集合类型，比如ArrayList，实现了RandomAccess接口，也就是支持快速随机访问，对于查找友好
>
> 时间复杂度为O(1)
>
> 但是对于链表而言（HashMap为单向不循环换链表），对于插入友好，对于查找不友好。随着链表长度边长查找时间随链表长度呈线性增长。时间复杂度近似为O(n)
>
> 此操作就是防止链表过长，导致查询效率慢的问题（当然哦，链表长度不会超过8）

首先我们通过`e.hash & （length-1）`进行模运算取余将节点散列在数组上，区别一下。

oldCap为2的幂次方整数。

举例：

e.hash为：       1001 0011 1010 0101 0110 0001 1110 1100

oldCap为：16  0000 0000 0000 0000 0000 0000 0001 0000

与运算：		    0000 0000 0000 0000 0000 0000 0000 0000

e.hash为：       1001 0011 1010 0101 0110 0001 1111 1100

oldCap为：16  0000 0000 0000 0000 0000 0000 0001 0000

与运算：		    0000 0000 0000 0000 0000 0000 0001 0000

==也就是结果为，oldCap的二进制表示法的最高有效位和e.hash对应位置的值进行与运算==

==结果只有两种：0  或    oldCap。而且是随机的==

也就是将原长链表拆分为尽可能的平分的两个短链表一个在低位（lo），一个在高位（hi）

![image-20220225140958797](E:\programmeTools\idea\git\JavaBase\Base-Collection-02\Map.assets\image-20220225140958797.png)











