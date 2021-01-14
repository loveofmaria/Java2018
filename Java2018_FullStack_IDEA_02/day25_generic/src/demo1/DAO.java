package demo1;

import java.util.List;

// DAO:数据操作对象
public class DAO<T> {
    public void add(T t){}
    public boolean remove(int index){
    return true;
    }
    public T getIndex(int index){
        return null;
    }

    public List<T> getForList(int index){
        return null;
    }
}


class CustomerADO extends DAO<Customer> {

}