//package com.blog.blogApiCommons;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import com.baomidou.mybatisplus.annotation.FieldFill;
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.po.TableFill;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
//import java.util.ArrayList;
//
//public class MysqlGenerator {
//
//    public static void main(String[] args) {
//
//        // 要生成代码的表名配置
//        String[] tables = {
////                "dict",
////                "project",
////                "project_model_function",
////                "project_model_scientific",
////                "project_model_skill",
////                "project_model_vocational",
////                "project_position",
////                "project_position_join",
////                "project_position_group",
////                "project_position_recruit",
////                "reward_count",
////                "reward_history",
////                "objective",
////                "objective_accpeter",
////                "objective_accpeter_index",
////                "objective_index",
////                "exam_index",
////                "project_position_apply"
////                "user_reward_record"
//                "t_blog",
//                "t_comment",
//                "t_friend",
//                "t_message",
//                "t_picture",
//                "t_type",
//                "t_user"
//
//
//        };
//
//        // 代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // 1.全局配置
//        GlobalConfig gc = new GlobalConfig();
//        gc.setActiveRecord(true);//支持AR模式
//        String projectPath = System.getProperty("user.dir");
//        gc.setOutputDir(projectPath+"/blog_api_commons"+"/src/test/java/");
//        gc.setFileOverride(true);//文件覆盖
//        gc.setIdType(IdType.AUTO);//主键自增
//        gc.setServiceName("%sService");//设置接口名称是否有I
//        gc.setAuthor("bd");
//        gc.setBaseResultMap(true);//xml映射
//        gc.setBaseColumnList(true);//sql片段
////        gc.setSwagger2(true);//自动开启swagger2的支持、
//
//        mpg.setGlobalConfig(gc);
//
//        // 2.数据源配置
//        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://localhost:3306/blog?useSSL=false&useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8");
//        dsc.setDbType(DbType.MYSQL);
//        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("1111111111");
//        mpg.setDataSource(dsc);
//
//        // 3.策略配置
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig.setTablePrefix("t_");//去掉前缀
//        strategyConfig.setCapitalMode(true);//全局大小写命名
//        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);//字段驼峰命名
//
//        strategyConfig.setNaming(NamingStrategy.underline_to_camel);//表驼峰命名
//        strategyConfig.setEntityLombokModel(true);//使用lombok
//        strategyConfig.setInclude(tables);//生成使用的表
////        strategyConfig.setLogicDeleteFieldName("delete_status");//设置逻辑删除字段
//
////        strategyConfig.setSuperEntityColumns(new String[] { "id", "del","created_time","created_by","updated_time","updated_by" });
//
//        // 设置创建时间和更新时间自动填充策略
//        TableFill created_date = new TableFill("create_time", FieldFill.INSERT);
////        TableFill created_by = new TableFill("created_by", FieldFill.INSERT);
//        TableFill updated_date = new TableFill("update_time", FieldFill.INSERT_UPDATE);
////        TableFill updated_by = new TableFill("updated_by", FieldFill.INSERT_UPDATE);
////        TableFill delete_status = new TableFill("delete_status", FieldFill.INSERT);
//
//
//        ArrayList<TableFill> tableFills = new ArrayList<>();
////        tableFills.add(delete_status);
//        tableFills.add(created_date);
////        tableFills.add(created_by);
////        tableFills.add(updated_by);
//        tableFills.add(updated_date);
//        strategyConfig.setTableFillList(tableFills);
//        mpg.setStrategy(strategyConfig);
//
//        // 4.包配置
//        PackageConfig pc = new PackageConfig();
//        pc.setParent("com.blog.blog_api_commons");
//        pc.setMapper("mapper");
//        pc.setService("service");
//        pc.setServiceImpl("serviceimpl");
//        pc.setController("controller");
//        pc.setEntity("module.po");
////        pc.setXml("mapper");
//        mpg.setPackageInfo(pc);
//
//        // 5.执行
//        mpg.execute();
//    }
//
//
//
//}
