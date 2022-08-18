package generator.domain.common;

import org.springframework.beans.BeanUtils;

/**
 * Out.
 *
 * @author 刘斌
 * @version 0.0.1
 * @serial 2022-08-16 : base version.
 */
public interface Out<V, E> {
    /**
     * 转换一下
     *
     * @param entity 转换实体
     * @return 对象
     */

    @SuppressWarnings("unchecked")
    default V from(E entity) {
        BeanUtils.copyProperties(entity, this);
        return (V) this;
    }

    /**
     * zai转换一下
     *
     * @param clazz class
     * @return obj
     */
    default E to(Class<E> clazz) {
        E res;
        try {
            res = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        BeanUtils.copyProperties(this, res);
        return res;
    }
}
