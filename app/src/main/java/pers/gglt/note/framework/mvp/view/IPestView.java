package pers.gglt.note.framework.mvp.view;

/**
 * 注释:定义出所有UI逻辑
 *
 * @author fanchunchun
 * @date 2018/4/3
 */

public interface IPestView {
    //显示DropEditText的数据(使用会掉的方式返回数据)
    void showPest(String[] pest);
    void setDate(String date); //显示当前时间
    void setLatlng(String[] latlng); //显示当前的经纬度
}