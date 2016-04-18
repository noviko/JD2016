package projects.telushko.servlets.dao;

import java.sql.SQLException;

public class Order {
    public Order(){}
    public Order(Integer vehicle,Integer order_type){
        this.fk_vehicle=vehicle;
        this.fk_order_type=order_type;
    }
    private Integer fk_vehicle;
    private Integer fk_order_type;
    private Integer fk_feedback;
    private Integer id;
    private Integer fk_status;

    public Integer getVehicle() {
        return fk_vehicle;
    }

    public void setVehicle(Integer vehicle) {
        this.fk_vehicle = vehicle;
    }

    public Integer getOrder_type() {
        return fk_order_type;
    }

    public void setOrder_type(Integer order_type) {
        this.fk_order_type = order_type;
    }

    public Integer getFeedback() {
        return fk_feedback;
    }

    public void setFeedback(Integer feedback) {
        this.fk_feedback = feedback;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return fk_status;
    }

    public void setStatus(Integer status) {
        this.fk_status = status;
    }

    @Override
    public String toString() {
        String res="";
        try{
            res="Order{" +
                    "vehicle=" + new RoleDAO().getRole(fk_vehicle) +
                    ", order_type=" + new OrderTypeDAO().getOrderType(fk_order_type) +
                    ", feedback=" + new FeedbackDAO().getFeedback(fk_feedback) +
                    ", id=" + id +
                    ", status=" + new StatusDAO().getStatus(fk_status) +
                    '}';
        }
        catch (SQLException e){res=e.toString();}
        return res;
    }

}
