package com.cha102.diyla.diyOrder;

import java.sql.Date;
import java.util.List;

public interface DiyOrderDAO_interface {
    public void insert(DiyOrderVO diyOrderVO);
    public void update(DiyOrderVO diyOrderVO);
    public void delete(Integer diyOrderNo);
    public DiyOrderVO findByPrimaryKey(Integer diyOrderNo);
    
    // 查所有訂單
    public List<DiyOrderVO> getAll();
    // 該會員所有訂單
    public List<DiyOrderVO> getAllByMemID(Integer memId);
    // 查會員於該時間以及時段內的訂單
    public List<DiyOrderVO> getAllByMemIDDatePeriod(Integer memId, Date diyReserveDate,Integer diyPeriod);
    // 查該時間以及時段內的所有訂單 (for 現場點名人員)
    public List<DiyOrderVO> getAllByDatePeriod(Date diyReserveDate,Integer diyPeriod);
    // 查詢該時段所有正常訂單的會員(已點名完總覽)	
    public List<DiyOrderVO> getAllByDatePeriodAfter(Date diyReserveDate,Integer diyPeriod);
   
    // 該會員所有取消訂單
    public List<DiyOrderVO> getDeleteByID(Integer memId);
    
  
    
    
    // 查詢所有退款審核訂單
    public List<DiyOrderVO> getAllRefundod();
}