




select * from hierarchy_level1 l1 left join hierarchy_level2 l2  on   l1.level_1id = l2.level_1id


select * from Level_Index_Master levels where  levels.level_1id='1' and
 levels.level_2id='11' and levels.level_3id='-1'