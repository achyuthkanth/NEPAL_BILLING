
    create table "public"."alarm_data"(
        "node_number" varchar(20) default 'NULL::character varying' not null,
       "node_date_time" timestamp not null,
       "node_date" date not null,
       "node_time" time,
       "meter_number" varchar(45) not null,
       "meter_date_time" timestamp not null,
       "meter_date" date not null,
       "meter_time" time,
       "alarm_date" timestamp not null,
       "inserted_date" timestamp default 'NULL::timestamp without time zone',
       "alarm_code" varchar(10) default 'NULL::character varying',
       "alarm_description" varchar(100) default 'NULL::character varying',
       "sequence_number" varchar(10) default 'NULL::character varying',
        constraint "alarm_data_pkey" primary key ("node_number","node_date_time")
    );

    create unique index "alarm_data_pkey" on "public"."alarm_data"("node_number","node_date_time");
    create index "Ind_alarmcode_meter_date" on "public"."alarm_data"("meter_number","meter_date","alarm_code");
    create index "Ind_alarmcode_node_date" on "public"."alarm_data"("node_number","node_date","alarm_code");
    create index "Ind_meter_date" on "public"."alarm_data"("meter_number","meter_date");
    create index "Ind_meter_date_time" on "public"."alarm_data"("meter_number","meter_date","meter_time");
    create index "Ind_node_date" on "public"."alarm_data"("node_number","node_date");
    create index "Ind_node_date_time" on "public"."alarm_data"("node_number","node_date","node_time");