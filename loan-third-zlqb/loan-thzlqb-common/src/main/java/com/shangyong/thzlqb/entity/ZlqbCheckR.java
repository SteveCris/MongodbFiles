package com.shangyong.thzlqb.entity;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ZlqbCheckR implements Serializable {
    //校验id
    @ApiModelProperty(value = "校验id")
    private String checkId;

    //身份证号
    @ApiModelProperty(value = "身份证号")
    private String idCard;

    //是否可以借款0 否 1 是
    @ApiModelProperty(value = "是否可以借款0 否 1 是")
    private Integer canLoan;

    //是否存量用户0 否 1 是
    @ApiModelProperty(value = "是否存量用户0 否 1 是")
    private Integer stock;

    //null,1黑名单2在贷3被拒记录4其它
    @ApiModelProperty(value = "null,1黑名单2在贷3被拒记录4其它")
    private Integer rejectReason;

    //创建时间
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    //扩展字段1
    @ApiModelProperty(value = "扩展字段1")
    private String ext1;

    //扩展字段2
    @ApiModelProperty(value = "扩展字段2")
    private String ext2;

    @ApiModelProperty(value = "描述信息")
    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * 获取校验id
     *
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     * 设置校验id
     *
     * @param checkId 校验id
     */
    public void setCheckId(String checkId) {
        this.checkId = checkId == null ? null : checkId.trim();
    }

    /**
     * 获取身份证号
     *
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 获取是否可以借款0 否 1 是
     *
     */
    public Integer getCanLoan() {
        return canLoan;
    }

    /**
     * 设置是否可以借款0 否 1 是
     *
     * @param canLoan 是否可以借款0 否 1 是
     */
    public void setCanLoan(Integer canLoan) {
        this.canLoan = canLoan;
    }

    /**
     * 获取是否存量用户0 否 1 是
     *
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * 设置是否存量用户0 否 1 是
     *
     * @param stock 是否存量用户0 否 1 是
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * 获取null,1黑名单2在贷3被拒记录4其它
     *
     */
    public Integer getRejectReason() {
        return rejectReason;
    }

    /**
     * 设置null,1黑名单2在贷3被拒记录4其它
     *
     * @param rejectReason null,1黑名单2在贷3被拒记录4其它
     */
    public void setRejectReason(Integer rejectReason) {
        this.rejectReason = rejectReason;
    }

    /**
     * 获取创建时间
     *
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取扩展字段1
     *
     */
    public String getExt1() {
        return ext1;
    }

    /**
     * 设置扩展字段1
     *
     * @param ext1 扩展字段1
     */
    public void setExt1(String ext1) {
        this.ext1 = ext1 == null ? null : ext1.trim();
    }

    /**
     * 获取扩展字段2
     *
     */
    public String getExt2() {
        return ext2;
    }

    /**
     * 设置扩展字段2
     *
     * @param ext2 扩展字段2
     */
    public void setExt2(String ext2) {
        this.ext2 = ext2 == null ? null : ext2.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", checkId=").append(checkId);
        sb.append(", idCard=").append(idCard);
        sb.append(", canLoan=").append(canLoan);
        sb.append(", stock=").append(stock);
        sb.append(", rejectReason=").append(rejectReason);
        sb.append(", createTime=").append(createTime);
        sb.append(", ext1=").append(ext1);
        sb.append(", ext2=").append(ext2);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}