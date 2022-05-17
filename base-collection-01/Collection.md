## 集合框架
#### Collection ext Iterable

<img src="E:\programmeTools\idea\git\JavaBase\Base-Collection-01\Collection.assets\java-collection-hierarchy.9733f6ea.png" alt="img" style="zoom:67%;" />

`List`(对付顺序的好帮手): 存储的元素是有序的、可重复的。

`Set`(注重独一无二的性质): 存储的元素是无序的、不可重复的。

`Queue`(实现排队功能的叫号机): 按特定的排队规则来确定先后顺序，存储的元素是有序的、可重复的。

`Map`(用 key 来搜索的专家): 使用键值对（key-value）存储，类似于数学上的函数 y=f(x)，"x" 代表 key，"y" 代表 value，key 是无序的、不可重复的，value 是无序的、可重复的，每个键最多映射到一个值。



#### List

用于存储有序的数据，有序、可重复。（底层以数组实现，有序指的是内存地址有序）

##### ArrayList

###### 底层实现

- 构造器

```java
//无参，elementData 数组默认为空
ArrayList();
//有参，初始化容量，elementData=new Object[initialCapacity];##此刻ArrayList size还是为0
ArrayList(int initialCapacity);
//有参集合， 集合，elementData = c.toArray(); 如果集合内对象不为Object则拷贝一下 
ArrayList(Collection<? extends Object> c);
```

- ArrayList(Collection<? extends Object> c)细解

```java
public ArrayList(Collection<? extends E> c) {
    //初始化elementData
    elementData = c.toArray();
    //初始化size  
    if ((size = elementData.length) != 0) {
        //复制为Object类型数组
        if (elementData.getClass() != Object[].class)
            elementData = Arrays.copyOf(elementData, size, Object[].class);
    } else {
        //当集合元素数量为0，初始化为kong数组
        this.elementData = EMPTY_ELEMENTDATA;
    }
}
```

​	`Arrays.copyOf(U[] original, int newLength, Class<? extends T[]> newType) `方法

参数：原数组、拷贝长度、拷贝类型（Object.class）

​	`System.arraycopy`方法

```
//本地方法
//参数 原数组、原数组起始位置、目标数组、目标数组其实位置、拷贝长度
public static native void arraycopy(Object src,  int  srcPos,
                                        Object dest, int destPos,
                                        int length);
```

###### 扩容机制

`add`方法分析

```java
public boolean add(E e) {
    //判断是否需要扩容
    ensureCapacityInternal(size + 1);  // Increments modCount!!
    elementData[size++] = e;
    return true;
}
```

`ensureCapacityInternal`方法分析（确保内部容量）

```java
private void ensureCapacityInternal(int minCapacity) {
    ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
}
//计算容量 如果是默认空数组，返回DEFAULT_CAPACITY（10） 否则返回minCapacity
private static int calculateCapacity(Object[] elementData, int minCapacity) {
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
        return Math.max(DEFAULT_CAPACITY, minCapacity);
    }
    return minCapacity;
}
//确保显示容量，如果最小要求容量大于数组长度 就扩容
private void ensureExplicitCapacity(int minCapacity) {
    modCount++;
    // overflow-conscious code
    if (minCapacity - elementData.length > 0)
        grow(minCapacity);
}
//扩容核心方法：先扩1.5倍（1+左移一位） 如果容量还是小于最小要求容量，直接容量等于最小要求容量。如果长度大于最大数组长度（int类型范围-8）  就赋为int类型最大长度
//最后调用Arrays.copy方法，拷贝一份
private void grow(int minCapacity) {
    int oldCapacity = elementData.length;
    int newCapacity = oldCapacity + (oldCapacity >> 1);
    if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;
    if (newCapacity - MAX_ARRAY_SIZE > 0)
        newCapacity = hugeCapacity(minCapacity);
    elementData = Arrays.copyOf(elementData, newCapacity);
}
```

总结：

```bash
ArrayList底层是以数组保存数据的
如果是走无参构造器，数组为空数组，数组内元素未初始化，在首次add时，扩容量minCapacity(10),触发扩容（grow），扩容量为10，并复制一份数组此时数组内元素初始化（Array.copyOf  System.copyarray[natice]）。之后扩容量大于10时才会再次触发扩容1.5倍。
如果走有参构造（initCapacity），当扩容量minCapacity大于initCapacity触发扩容机制。
若果是有参构造（Collection），c.toArray()转数组，初始化elementData，add触发扩容1.5倍

1、走无参构造时，elementData为空，*未初始化数组内元素值*
	首次调用add方法时，首先计算出扩容量，也就是minCapacity（10），此时elementData.legth=0触发扩容grow，容量为10.
	调用Arrays.copyOf()方法拷贝一份，此时真正初始化数组（null默认值）。设置值
	第二次add，计算出扩容量也就是minCapacity（直接返回2），此时elementData.legth=10不触发扩容grow。设置值.
	直到minCapacity大于10再次触发扩容，扩1.5倍
2、有参构造，elementData为new Object[initialCapacity]，*初始化数组内元素值(null)*
	首次调用add，计算minCapacity（1），未触发扩容，设置值
	直到minCapacity大于initialCapacity，触发扩容
```

问题：当一次性需要放入大批量的对象到ArrayList数组中，如何避免多次扩容（扩容需要复制数组，浪费资源）

1、使用有参构造初始化时给予足够空间。

2、ensureCapacity手动设置足够容量



##### LinkedList

基于双向链表，每一个元素都是一个节点(Node)，节点内保存当前节点数据以及上一个节点（prev）和下一个节点（next）的引用

属性：size   first(Node)  last(Node)

- 构造器

```java
//无参的
public LinkedList() {
}
//有参的
public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}
//检查下标  下标大于0 小于size
checkPositionIndex(index);
//addAll
找到需要插入的位置的节点node(index)【二分法，左移一位】,他的上一个节点.prev。
如果上一个节点为空，那么插入的位置为first（循环插入）
```

- 插入方法

> last节点为当前节点的上一个节点，当前节点为last节点。
>
> 特殊：last节点为空（LinkedList为空），当前节点为first 也为last
>
> succ的上一个节点为当前节点（newNode），succ的原上一个节点为当前节点的下一个节点，当前节点的下一个节点为succ，succ的原上一个节点的下一个节点为当前节点

```java
//默认插入尾部
public boolean add(E e) {
    linkLast(e);
    return true;
}

public void add(int index, E element) {
    checkPositionIndex(index);
    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));
}

void linkLast(E e) {
    final Node<E> l = last;
    //last节点为当前节点上一个节点
    final Node<E> newNode = new Node<>(l, e, null);
    //当前节点为最后一个节点
    last = newNode;
    //最后一个节点为空，linkList为空，当前节点即为first也为last
    if (l == null)
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}

//e  插入到succ前面
void linkBefore(E e, Node<E> succ) {
    final Node<E> pred = succ.prev;
    final Node<E> newNode = new Node<>(pred, e, succ);
    succ.prev = newNode;
    if (pred == null)
        first = newNode;
    else
        pred.next = newNode;
    size++;
    modCount++;
}
```

- set方法(覆盖)

```java
public E set(int index, E element) {
    checkElementIndex(index);
    Node<E> x = node(index);
    E oldVal = x.item;
    x.item = element;
    return oldVal;
}
```

- get方法（二分法）

> 如果下标小于 size<<1（一半），从first开始遍历
>
> 如果下标大于 size<<1（一半），从last开始遍历

```java
public E get(int index) {
    checkElementIndex(index);
    return node(index).item;
}
```