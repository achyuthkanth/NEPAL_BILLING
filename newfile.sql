



select * from bio_user_details


ALTER TABLE meter_master
ADD COLUMN consumer_Id varchar(50);

select * from Consumer_Meter_Master where module_Type_Name='sss';
 
 select * from hierarchy_level2;
 
 
  select * from hierarchy_level1;
 select * from application_master master  where  master.applicationname = 'Atil'  order by master.applicationuniquecode asc
 
 
 select * from consumer_master where consumer_id='122222'
 
select * from consumer_meter_master;

 select * from Consumer_Master master,Level_Index_Master levels where   master.indexid=levels.indexid and  
( master.consumer_Id = '131313'  or  master.consumer_Id like '%12%' )