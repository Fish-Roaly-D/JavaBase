package com.roily.designpatterns.dpmain.memento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;

/**
 * @className：Original
 * @author: rolyfish
 * @description: 原始类
 * @dte: 2022/6/20 12:42
 */
@Accessors(chain = true)
@AllArgsConstructor
@Data
@ToString
public class Original {
    /**
     * 状态，决定保存这个状态
     */
    String state;

    /**
     * 状态对应数据
     */
    String value;

    /**
     * 备忘
     * @return
     */
    public Memento createMemento() {
        return new Memento(state, value);
    }

    /**
     * 恢复
     * @param memento
     */
    public void resStore(Memento memento) {
        BeanUtils.copyProperties(memento.reStore(), this);
    }

}
