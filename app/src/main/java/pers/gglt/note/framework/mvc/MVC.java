package pers.gglt.note.framework.mvc;

public class MVC {
    /**概念*/
    // M (处理数据逻辑) (通知V更新数据)
    // V (展示数据)
    // C (M和V间数据传递)

    /**流程*/
    // 用户事件通知V,再通知到C,再通知到M，M处理完后通知V更新

    /**缺点*/
    // 耦合 (V改动会导致M和C改动) (Activity/Fragment同时负责V和C)
    // View直接从Model读取数据
}
