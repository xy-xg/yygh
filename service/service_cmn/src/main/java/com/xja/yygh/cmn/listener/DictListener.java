package com.xja.yygh.cmn.listener;import com.alibaba.excel.context.AnalysisContext;import com.alibaba.excel.event.AnalysisEventListener;import com.xja.yygh.cmn.mapper.DictMapper;import com.xja.yygh.model.cmn.Dict;import com.xja.yygh.vo.cmn.DictEeVo;import org.springframework.beans.BeanUtils;/** * @Author xiaoYan * @Data 2022/12/6 11:38 * 时间不早了  注意休息 */public class DictListener extends AnalysisEventListener<DictEeVo> {    private DictMapper dictMapper;    public DictListener(DictMapper dictMapper) {        this.dictMapper = dictMapper;    }    //一行一行读取    @Override    public void invoke(DictEeVo dictEeVo, AnalysisContext analysisContext) {        //调用方法添加数据库        Dict dict = new Dict();        BeanUtils.copyProperties(dictEeVo,dict);        dictMapper.insert(dict);    }    @Override    public void doAfterAllAnalysed(AnalysisContext analysisContext) {    }}