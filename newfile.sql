

select * from module_Master;

delete from module_Master where module_Type_Name=' ';

select * from module_details where module_Type_Name='sss';


select * from module_Master master  where  master.moduleTypeName like '%bb%'  and  master.MODULE DESCRIPTION = 'ss'


select * from module_Master master  where  master.module_Type_Name like '%aa%'  or 
 master.module_Description = 'ss'  or master.module_Description like '%tt%'
 
 select * from param_table;
 
 select * from application_master master  where  master.applicationname = 'Atil'  order by master.applicationuniquecode asc