package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;

public interface ItemService {
    //查询商品列表
    public EasyUIDataGridResult getItemList(int page, int rows);

}
