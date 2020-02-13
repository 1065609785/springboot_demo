package com.demo.dao.model;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 * 车购税代开申请
 * </p>
 *
 * @author zhaoshouyun
 * @since 2019-12-18
 */
@TableName("CGS_DKSQ")
public class CgsDksq extends Model<CgsDksq> {

    private static final long serialVersionUID = 1L;

    /**
     * 代开申请uuid
     */
    @TableId("DKSQ_UUID")
    private String dksqUuid;

    /**
     * 金三申报uuid
     */
    @TableField("GT3_SBUUID")
    private String gt3Sbuuid;

    /**
     * 金三车船税申报uuid
     */
    @TableField("GT3_CGS_SBUUID")
    private String gt3CgsSbuuid;

    /**
     * 金三凭证序号
     */
    @TableField("GT3_PZXH")
    private BigDecimal gt3Pzxh;

    /**
     * 纳税人识别号
     */
    @TableField("NSRSBH")
    private String nsrsbh;

    /**
     * 纳税人名称
     */
    @TableField("NSRMC")
    private String nsrmc;

    /**
     * 纳税人证件类型
     */
    @TableField("NSR_ZJLX")
    private String nsrZjlx;

    /**
     * 纳税人证件名称
     */
    @TableField("NSR_ZJMC")
    private String nsrZjmc;

    /**
     * 纳税人联系电话
     */
    @TableField("NSR_LXDH")
    private String nsrLxdh;

    /**
     * 纳税人行业代码
     */
    @TableField("NSR_HY_DM")
    private String nsrHyDm;

    /**
     * 纳税人注册类型代码
     */
    @TableField("NSR_ZCLXDM")
    private String nsrZclxdm;

    /**
     * 上牌行政区划
     */
    @TableField("SP_XZQH_CODE")
    private String spXzqhCode;

    /**
     * 车辆产地 1国产  2进口
     */
    @TableField("CLCD")
    private String clcd;

    /**
     * 发票代码
     */
    @TableField("FPDM")
    private String fpdm;

    /**
     * 发票号码
     */
    @TableField("FPHM")
    private String fphm;

    /**
     * 车辆识别代号
     */
    @TableField("CLSBDH")
    private String clsbdh;

    /**
     * 机动车出厂合格证编号
     */
    @TableField("JDCCCHGZBH")
    private String jdccchgzbh;

    /**
     * 申报状态：0未申报  1申报成功 2申报失败
     */
    @TableField("SBZT")
    private String sbzt;

    /**
     * 申报时间
     */
    @TableField("SB_SJ")
    private Date sbSj;

    /**
     * 申报失败原因
     */
    @TableField("SB_SBYY")
    private String sbSbyy;

    /**
     * 缴款状态：0未交款  1缴款中 2缴款成功 3缴款失败
     */
    @TableField("JK_ZT")
    private String jkZt;

    /**
     * 缴款时间
     */
    @TableField("JKSJ")
    private Date jksj;

    /**
     * 缴款失败原因
     */
    @TableField("JKSB_SBYY")
    private String jksbSbyy;

    /**
     * 开具完税证明状态：0 未开具 1开具成功 2开具失败 
     */
    @TableField("KJWSZM_ZT")
    private String kjwszmZt;

    /**
     * 开具完税证明时间
     */
    @TableField("KJWSZM_SJ")
    private Date kjwszmSj;

    /**
     * 开具完税证明失败原因
     */
    @TableField("KJWSZM_SBYY")
    private String kjwszmSbyy;

    /**
     * 车辆厂牌||车辆厂牌
     */
    @TableField("CLCP")
    private String clcp;

    /**
     * 车辆型号||车辆型号
     */
    @TableField("CLXH")
    private String clxh;

    /**
     * 车辆类别代码
     */
    @TableField("CLLB_DM")
    private String cllbDm;

    /**
     * 车辆类型
     */
    @TableField("CLLX")
    private String cllx;

    /**
     * 燃料（能源）种类代码||燃料（能源）种类代码
     */
    @TableField("CLGZSRLNYZL_DM")
    private String clgzsrlnyzlDm;

    /**
     * 生产企业名称
     */
    @TableField("SCQYMC")
    private String scqymc;

    /**
     * 产地属性 1国产  2进口
     */
    @TableField("CDSX")
    private String cdsx;

    /**
     * 车辆购置地属性代码 1境内 2境外
     */
    @TableField("CLGZDSX_DM")
    private String clgzdsxDm;

    /**
     * 最低计税价格
     */
    @TableField("ZDJSJG")
    private BigDecimal zdjsjg;

    /**
     * 核定计税价格
     */
    @TableField("HDJSJG")
    private BigDecimal hdjsjg;

    /**
     * 车辆购置税申报类型代码
     */
    @TableField("CLGZSSBLX_DM")
    private String clgzssblxDm;

    /**
     * 退抵税费原因类型代码
     */
    @TableField("TDSFYYLX_DM")
    private String tdsfyylxDm;

    /**
     * 车辆购置税计税方式代码
     */
    @TableField("CLGZSJSFS_DM")
    private String clgzsjsfsDm;

    /**
     * 车辆购置税特殊计税依据类型代码
     */
    @TableField("CLGZSTSJSYJLX_DM")
    private String clgzstsjsyjlxDm;

    /**
     * 车辆购置税免（减）税条件代码
     */
    @TableField("CLGZSMJSTJ_DM")
    private String clgzsmjstjDm;

    /**
     * 原完税证明号码
     */
    @TableField("YWSZMHM")
    private String ywszmhm;

    /**
     * 机动车销售统一发票不含税价格合计
     */
    @TableField("JDCXSTYFPBHSJGHJ")
    private BigDecimal jdcxstyfpbhsjghj;

    /**
     * 二手车销售统一发票不含税价格合计
     */
    @TableField("ESCXSTYFPBHSJGHJ")
    private BigDecimal escxstyfpbhsjghj;

    /**
     * 初次纳税申报日期
     */
    @TableField("CCNSSBRQ")
    private Date ccnssbrq;

    /**
     * 免税条件消失日期
     */
    @TableField("MSTJXSRQ")
    private Date mstjxsrq;

    /**
     * 购置日期
     */
    @TableField("GZRQ")
    private Date gzrq;

    /**
     * 限缴期限
     */
    @TableField("XJQX")
    private Date xjqx;

    /**
     * 新能源汽车类型代码
     */
    @TableField("XNYQCLX_DM")
    private String xnyqclxDm;

    /**
     * 作废标志 0已作废  1未作废
     */
    @TableField("ZFBZ_1")
    private String zfbz1;

    /**
     * 作废人代码
     */
    @TableField("ZFR_DM")
    private String zfrDm;

    /**
     * 作废日期
     */
    @TableField("ZFRQ_1")
    private Date zfrq1;

    /**
     * 录入人代码
     */
    @TableField("LRR_DM")
    private String lrrDm;

    /**
     * 录入日期
     */
    @TableField("LRRQ")
    private Date lrrq;

    /**
     * 修改人代码
     */
    @TableField("XGR_DM")
    private String xgrDm;

    /**
     * 修改日期
     */
    @TableField("XGRQ")
    private Date xgrq;

    /**
     * 征收机关代码
     */
    @TableField("ZSJG_DM")
    private String zsjgDm;

    /**
     * 申报计税价格
     */
    @TableField("SBJSJG")
    private BigDecimal sbjsjg;

    /**
     * 计税价格
     */
    @TableField("JSJG")
    private BigDecimal jsjg;

    /**
     * 税率
     */
    @TableField("SL_1")
    private BigDecimal sl1;

    /**
     * 减免税额
     */
    @TableField("JMSE")
    private BigDecimal jmse;

    /**
     * 应纳税额
     */
    @TableField("YNSE")
    private BigDecimal ynse;

    /**
     * 应补(退)税额
     */
    @TableField("YBTSE")
    private BigDecimal ybtse;

    /**
     * 已缴税额
     */
    @TableField("YJSE")
    private BigDecimal yjse;

    /**
     * 滞纳金
     */
    @TableField("ZNJ")
    private BigDecimal znj;

    /**
     * 应缴交合计
     */
    @TableField("YJJHJ")
    private BigDecimal yjjhj;

    /**
     * 登记序号
     */
    @TableField("DJXH")
    private BigDecimal djxh;

    /**
     * 发动机号码
     */
    @TableField("FDJHM")
    private String fdjhm;

    /**
     * 车辆序列号
     */
    @TableField("CLXLH")
    private String clxlh;

    /**
     * dai'l车辆名称
     */
    @TableField("CLMC")
    private String clmc;

    /**
     * 代理机构UUID
     */
    @TableField("DLJG_UUID")
    private String dljgUuid;

    /**
     * 挂车免税标志 0不免税  1免税 
     */
    @TableField("GCMSBZ")
    private String gcmsbz;

    /**
     * 是否新能源  0不是新能源   1是新能源
     */
    @TableField("SFXNY")
    private String sfxny;

    /**
     * 创建人id
     */
    @TableField("CJR_ID")
    private String cjrId;

    /**
     * 创建人用户名
     */
    @TableField("CJR_YHM")
    private String cjrYhm;

    /**
     * 创建人名称
     */
    @TableField("CJR_MC")
    private String cjrMc;

    /**
     * 开票员企业名称
     */
    @TableField("KPY_QY_MC")
    private String kpyQyMc;

    /**
     * 开票员企业税号
     */
    @TableField("KPY_QY_NSRSBH")
    private String kpyQyNsrsbh;

    /**
     * 开票员企业地址
     */
    @TableField("KPY_QY_DZ")
    private String kpyQyDz;

    /**
     * 排气量
     */
    @TableField("PQL")
    private String pql;

    /**
     * 座位数
     */
    @TableField("ZWS")
    private String zws;

    /**
     * 功率
     */
    @TableField("GL")
    private String gl;

    /**
     * 主要配置
     */
    @TableField("ZYPZ")
    private String zypz;

    /**
     * 纳税人类型   0企业  1自然人
     */
    @TableField("NSR_LX")
    private String nsrLx;

    /**
     * 纳税人地址
     */
    @TableField("NSR_DZ")
    private String nsrDz;

    public String getDksqUuid() {
        return dksqUuid;
    }

    public void setDksqUuid(String dksqUuid) {
        this.dksqUuid = dksqUuid;
    }
    public String getGt3Sbuuid() {
        return gt3Sbuuid;
    }

    public void setGt3Sbuuid(String gt3Sbuuid) {
        this.gt3Sbuuid = gt3Sbuuid;
    }
    public String getGt3CgsSbuuid() {
        return gt3CgsSbuuid;
    }

    public void setGt3CgsSbuuid(String gt3CgsSbuuid) {
        this.gt3CgsSbuuid = gt3CgsSbuuid;
    }
    public BigDecimal getGt3Pzxh() {
        return gt3Pzxh;
    }

    public void setGt3Pzxh(BigDecimal gt3Pzxh) {
        this.gt3Pzxh = gt3Pzxh;
    }
    public String getNsrsbh() {
        return nsrsbh;
    }

    public void setNsrsbh(String nsrsbh) {
        this.nsrsbh = nsrsbh;
    }
    public String getNsrmc() {
        return nsrmc;
    }

    public void setNsrmc(String nsrmc) {
        this.nsrmc = nsrmc;
    }
    public String getNsrZjlx() {
        return nsrZjlx;
    }

    public void setNsrZjlx(String nsrZjlx) {
        this.nsrZjlx = nsrZjlx;
    }
    public String getNsrZjmc() {
        return nsrZjmc;
    }

    public void setNsrZjmc(String nsrZjmc) {
        this.nsrZjmc = nsrZjmc;
    }
    public String getNsrLxdh() {
        return nsrLxdh;
    }

    public void setNsrLxdh(String nsrLxdh) {
        this.nsrLxdh = nsrLxdh;
    }
    public String getNsrHyDm() {
        return nsrHyDm;
    }

    public void setNsrHyDm(String nsrHyDm) {
        this.nsrHyDm = nsrHyDm;
    }
    public String getNsrZclxdm() {
        return nsrZclxdm;
    }

    public void setNsrZclxdm(String nsrZclxdm) {
        this.nsrZclxdm = nsrZclxdm;
    }
    public String getSpXzqhCode() {
        return spXzqhCode;
    }

    public void setSpXzqhCode(String spXzqhCode) {
        this.spXzqhCode = spXzqhCode;
    }
    public String getClcd() {
        return clcd;
    }

    public void setClcd(String clcd) {
        this.clcd = clcd;
    }
    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }
    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }
    public String getClsbdh() {
        return clsbdh;
    }

    public void setClsbdh(String clsbdh) {
        this.clsbdh = clsbdh;
    }
    public String getJdccchgzbh() {
        return jdccchgzbh;
    }

    public void setJdccchgzbh(String jdccchgzbh) {
        this.jdccchgzbh = jdccchgzbh;
    }
    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt;
    }
    public Date getSbSj() {
        return sbSj;
    }

    public void setSbSj(Date sbSj) {
        this.sbSj = sbSj;
    }
    public String getSbSbyy() {
        return sbSbyy;
    }

    public void setSbSbyy(String sbSbyy) {
        this.sbSbyy = sbSbyy;
    }
    public String getJkZt() {
        return jkZt;
    }

    public void setJkZt(String jkZt) {
        this.jkZt = jkZt;
    }
    public Date getJksj() {
        return jksj;
    }

    public void setJksj(Date jksj) {
        this.jksj = jksj;
    }
    public String getJksbSbyy() {
        return jksbSbyy;
    }

    public void setJksbSbyy(String jksbSbyy) {
        this.jksbSbyy = jksbSbyy;
    }
    public String getKjwszmZt() {
        return kjwszmZt;
    }

    public void setKjwszmZt(String kjwszmZt) {
        this.kjwszmZt = kjwszmZt;
    }
    public Date getKjwszmSj() {
        return kjwszmSj;
    }

    public void setKjwszmSj(Date kjwszmSj) {
        this.kjwszmSj = kjwszmSj;
    }
    public String getKjwszmSbyy() {
        return kjwszmSbyy;
    }

    public void setKjwszmSbyy(String kjwszmSbyy) {
        this.kjwszmSbyy = kjwszmSbyy;
    }
    public String getClcp() {
        return clcp;
    }

    public void setClcp(String clcp) {
        this.clcp = clcp;
    }
    public String getClxh() {
        return clxh;
    }

    public void setClxh(String clxh) {
        this.clxh = clxh;
    }
    public String getCllbDm() {
        return cllbDm;
    }

    public void setCllbDm(String cllbDm) {
        this.cllbDm = cllbDm;
    }
    public String getCllx() {
        return cllx;
    }

    public void setCllx(String cllx) {
        this.cllx = cllx;
    }
    public String getClgzsrlnyzlDm() {
        return clgzsrlnyzlDm;
    }

    public void setClgzsrlnyzlDm(String clgzsrlnyzlDm) {
        this.clgzsrlnyzlDm = clgzsrlnyzlDm;
    }
    public String getScqymc() {
        return scqymc;
    }

    public void setScqymc(String scqymc) {
        this.scqymc = scqymc;
    }
    public String getCdsx() {
        return cdsx;
    }

    public void setCdsx(String cdsx) {
        this.cdsx = cdsx;
    }
    public String getClgzdsxDm() {
        return clgzdsxDm;
    }

    public void setClgzdsxDm(String clgzdsxDm) {
        this.clgzdsxDm = clgzdsxDm;
    }
    public BigDecimal getZdjsjg() {
        return zdjsjg;
    }

    public void setZdjsjg(BigDecimal zdjsjg) {
        this.zdjsjg = zdjsjg;
    }
    public BigDecimal getHdjsjg() {
        return hdjsjg;
    }

    public void setHdjsjg(BigDecimal hdjsjg) {
        this.hdjsjg = hdjsjg;
    }
    public String getClgzssblxDm() {
        return clgzssblxDm;
    }

    public void setClgzssblxDm(String clgzssblxDm) {
        this.clgzssblxDm = clgzssblxDm;
    }
    public String getTdsfyylxDm() {
        return tdsfyylxDm;
    }

    public void setTdsfyylxDm(String tdsfyylxDm) {
        this.tdsfyylxDm = tdsfyylxDm;
    }
    public String getClgzsjsfsDm() {
        return clgzsjsfsDm;
    }

    public void setClgzsjsfsDm(String clgzsjsfsDm) {
        this.clgzsjsfsDm = clgzsjsfsDm;
    }
    public String getClgzstsjsyjlxDm() {
        return clgzstsjsyjlxDm;
    }

    public void setClgzstsjsyjlxDm(String clgzstsjsyjlxDm) {
        this.clgzstsjsyjlxDm = clgzstsjsyjlxDm;
    }
    public String getClgzsmjstjDm() {
        return clgzsmjstjDm;
    }

    public void setClgzsmjstjDm(String clgzsmjstjDm) {
        this.clgzsmjstjDm = clgzsmjstjDm;
    }
    public String getYwszmhm() {
        return ywszmhm;
    }

    public void setYwszmhm(String ywszmhm) {
        this.ywszmhm = ywszmhm;
    }
    public BigDecimal getJdcxstyfpbhsjghj() {
        return jdcxstyfpbhsjghj;
    }

    public void setJdcxstyfpbhsjghj(BigDecimal jdcxstyfpbhsjghj) {
        this.jdcxstyfpbhsjghj = jdcxstyfpbhsjghj;
    }
    public BigDecimal getEscxstyfpbhsjghj() {
        return escxstyfpbhsjghj;
    }

    public void setEscxstyfpbhsjghj(BigDecimal escxstyfpbhsjghj) {
        this.escxstyfpbhsjghj = escxstyfpbhsjghj;
    }
    public Date getCcnssbrq() {
        return ccnssbrq;
    }

    public void setCcnssbrq(Date ccnssbrq) {
        this.ccnssbrq = ccnssbrq;
    }
    public Date getMstjxsrq() {
        return mstjxsrq;
    }

    public void setMstjxsrq(Date mstjxsrq) {
        this.mstjxsrq = mstjxsrq;
    }
    public Date getGzrq() {
        return gzrq;
    }

    public void setGzrq(Date gzrq) {
        this.gzrq = gzrq;
    }
    public Date getXjqx() {
        return xjqx;
    }

    public void setXjqx(Date xjqx) {
        this.xjqx = xjqx;
    }
    public String getXnyqclxDm() {
        return xnyqclxDm;
    }

    public void setXnyqclxDm(String xnyqclxDm) {
        this.xnyqclxDm = xnyqclxDm;
    }
    public String getZfbz1() {
        return zfbz1;
    }

    public void setZfbz1(String zfbz1) {
        this.zfbz1 = zfbz1;
    }
    public String getZfrDm() {
        return zfrDm;
    }

    public void setZfrDm(String zfrDm) {
        this.zfrDm = zfrDm;
    }
    public Date getZfrq1() {
        return zfrq1;
    }

    public void setZfrq1(Date zfrq1) {
        this.zfrq1 = zfrq1;
    }
    public String getLrrDm() {
        return lrrDm;
    }

    public void setLrrDm(String lrrDm) {
        this.lrrDm = lrrDm;
    }
    public Date getLrrq() {
        return lrrq;
    }

    public void setLrrq(Date lrrq) {
        this.lrrq = lrrq;
    }
    public String getXgrDm() {
        return xgrDm;
    }

    public void setXgrDm(String xgrDm) {
        this.xgrDm = xgrDm;
    }
    public Date getXgrq() {
        return xgrq;
    }

    public void setXgrq(Date xgrq) {
        this.xgrq = xgrq;
    }
    public String getZsjgDm() {
        return zsjgDm;
    }

    public void setZsjgDm(String zsjgDm) {
        this.zsjgDm = zsjgDm;
    }
    public BigDecimal getSbjsjg() {
        return sbjsjg;
    }

    public void setSbjsjg(BigDecimal sbjsjg) {
        this.sbjsjg = sbjsjg;
    }
    public BigDecimal getJsjg() {
        return jsjg;
    }

    public void setJsjg(BigDecimal jsjg) {
        this.jsjg = jsjg;
    }
    public BigDecimal getSl1() {
        return sl1;
    }

    public void setSl1(BigDecimal sl1) {
        this.sl1 = sl1;
    }
    public BigDecimal getJmse() {
        return jmse;
    }

    public void setJmse(BigDecimal jmse) {
        this.jmse = jmse;
    }
    public BigDecimal getYnse() {
        return ynse;
    }

    public void setYnse(BigDecimal ynse) {
        this.ynse = ynse;
    }
    public BigDecimal getYbtse() {
        return ybtse;
    }

    public void setYbtse(BigDecimal ybtse) {
        this.ybtse = ybtse;
    }
    public BigDecimal getYjse() {
        return yjse;
    }

    public void setYjse(BigDecimal yjse) {
        this.yjse = yjse;
    }
    public BigDecimal getZnj() {
        return znj;
    }

    public void setZnj(BigDecimal znj) {
        this.znj = znj;
    }
    public BigDecimal getYjjhj() {
        return yjjhj;
    }

    public void setYjjhj(BigDecimal yjjhj) {
        this.yjjhj = yjjhj;
    }
    public BigDecimal getDjxh() {
        return djxh;
    }

    public void setDjxh(BigDecimal djxh) {
        this.djxh = djxh;
    }
    public String getFdjhm() {
        return fdjhm;
    }

    public void setFdjhm(String fdjhm) {
        this.fdjhm = fdjhm;
    }
    public String getClxlh() {
        return clxlh;
    }

    public void setClxlh(String clxlh) {
        this.clxlh = clxlh;
    }
    public String getClmc() {
        return clmc;
    }

    public void setClmc(String clmc) {
        this.clmc = clmc;
    }
    public String getDljgUuid() {
        return dljgUuid;
    }

    public void setDljgUuid(String dljgUuid) {
        this.dljgUuid = dljgUuid;
    }
    public String getGcmsbz() {
        return gcmsbz;
    }

    public void setGcmsbz(String gcmsbz) {
        this.gcmsbz = gcmsbz;
    }
    public String getSfxny() {
        return sfxny;
    }

    public void setSfxny(String sfxny) {
        this.sfxny = sfxny;
    }
    public String getCjrId() {
        return cjrId;
    }

    public void setCjrId(String cjrId) {
        this.cjrId = cjrId;
    }
    public String getCjrYhm() {
        return cjrYhm;
    }

    public void setCjrYhm(String cjrYhm) {
        this.cjrYhm = cjrYhm;
    }
    public String getCjrMc() {
        return cjrMc;
    }

    public void setCjrMc(String cjrMc) {
        this.cjrMc = cjrMc;
    }
    public String getKpyQyMc() {
        return kpyQyMc;
    }

    public void setKpyQyMc(String kpyQyMc) {
        this.kpyQyMc = kpyQyMc;
    }
    public String getKpyQyNsrsbh() {
        return kpyQyNsrsbh;
    }

    public void setKpyQyNsrsbh(String kpyQyNsrsbh) {
        this.kpyQyNsrsbh = kpyQyNsrsbh;
    }
    public String getKpyQyDz() {
        return kpyQyDz;
    }

    public void setKpyQyDz(String kpyQyDz) {
        this.kpyQyDz = kpyQyDz;
    }
    public String getPql() {
        return pql;
    }

    public void setPql(String pql) {
        this.pql = pql;
    }
    public String getZws() {
        return zws;
    }

    public void setZws(String zws) {
        this.zws = zws;
    }
    public String getGl() {
        return gl;
    }

    public void setGl(String gl) {
        this.gl = gl;
    }
    public String getZypz() {
        return zypz;
    }

    public void setZypz(String zypz) {
        this.zypz = zypz;
    }
    public String getNsrLx() {
        return nsrLx;
    }

    public void setNsrLx(String nsrLx) {
        this.nsrLx = nsrLx;
    }
    public String getNsrDz() {
        return nsrDz;
    }

    public void setNsrDz(String nsrDz) {
        this.nsrDz = nsrDz;
    }

    @Override
    protected Serializable pkVal() {
        return this.dksqUuid;
    }

    @Override
    public String toString() {
        return "CgsDksq{" +
            "dksqUuid=" + dksqUuid +
            ", gt3Sbuuid=" + gt3Sbuuid +
            ", gt3CgsSbuuid=" + gt3CgsSbuuid +
            ", gt3Pzxh=" + gt3Pzxh +
            ", nsrsbh=" + nsrsbh +
            ", nsrmc=" + nsrmc +
            ", nsrZjlx=" + nsrZjlx +
            ", nsrZjmc=" + nsrZjmc +
            ", nsrLxdh=" + nsrLxdh +
            ", nsrHyDm=" + nsrHyDm +
            ", nsrZclxdm=" + nsrZclxdm +
            ", spXzqhCode=" + spXzqhCode +
            ", clcd=" + clcd +
            ", fpdm=" + fpdm +
            ", fphm=" + fphm +
            ", clsbdh=" + clsbdh +
            ", jdccchgzbh=" + jdccchgzbh +
            ", sbzt=" + sbzt +
            ", sbSj=" + sbSj +
            ", sbSbyy=" + sbSbyy +
            ", jkZt=" + jkZt +
            ", jksj=" + jksj +
            ", jksbSbyy=" + jksbSbyy +
            ", kjwszmZt=" + kjwszmZt +
            ", kjwszmSj=" + kjwszmSj +
            ", kjwszmSbyy=" + kjwszmSbyy +
            ", clcp=" + clcp +
            ", clxh=" + clxh +
            ", cllbDm=" + cllbDm +
            ", cllx=" + cllx +
            ", clgzsrlnyzlDm=" + clgzsrlnyzlDm +
            ", scqymc=" + scqymc +
            ", cdsx=" + cdsx +
            ", clgzdsxDm=" + clgzdsxDm +
            ", zdjsjg=" + zdjsjg +
            ", hdjsjg=" + hdjsjg +
            ", clgzssblxDm=" + clgzssblxDm +
            ", tdsfyylxDm=" + tdsfyylxDm +
            ", clgzsjsfsDm=" + clgzsjsfsDm +
            ", clgzstsjsyjlxDm=" + clgzstsjsyjlxDm +
            ", clgzsmjstjDm=" + clgzsmjstjDm +
            ", ywszmhm=" + ywszmhm +
            ", jdcxstyfpbhsjghj=" + jdcxstyfpbhsjghj +
            ", escxstyfpbhsjghj=" + escxstyfpbhsjghj +
            ", ccnssbrq=" + ccnssbrq +
            ", mstjxsrq=" + mstjxsrq +
            ", gzrq=" + gzrq +
            ", xjqx=" + xjqx +
            ", xnyqclxDm=" + xnyqclxDm +
            ", zfbz1=" + zfbz1 +
            ", zfrDm=" + zfrDm +
            ", zfrq1=" + zfrq1 +
            ", lrrDm=" + lrrDm +
            ", lrrq=" + lrrq +
            ", xgrDm=" + xgrDm +
            ", xgrq=" + xgrq +
            ", zsjgDm=" + zsjgDm +
            ", sbjsjg=" + sbjsjg +
            ", jsjg=" + jsjg +
            ", sl1=" + sl1 +
            ", jmse=" + jmse +
            ", ynse=" + ynse +
            ", ybtse=" + ybtse +
            ", yjse=" + yjse +
            ", znj=" + znj +
            ", yjjhj=" + yjjhj +
            ", djxh=" + djxh +
            ", fdjhm=" + fdjhm +
            ", clxlh=" + clxlh +
            ", clmc=" + clmc +
            ", dljgUuid=" + dljgUuid +
            ", gcmsbz=" + gcmsbz +
            ", sfxny=" + sfxny +
            ", cjrId=" + cjrId +
            ", cjrYhm=" + cjrYhm +
            ", cjrMc=" + cjrMc +
            ", kpyQyMc=" + kpyQyMc +
            ", kpyQyNsrsbh=" + kpyQyNsrsbh +
            ", kpyQyDz=" + kpyQyDz +
            ", pql=" + pql +
            ", zws=" + zws +
            ", gl=" + gl +
            ", zypz=" + zypz +
            ", nsrLx=" + nsrLx +
            ", nsrDz=" + nsrDz +
        "}";
    }
}
