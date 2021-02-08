
INSERT INTO hierarchy_level1 VALUES(null,'NEA45','123','NEA45')
select * from hierarchy_level1;
select * from hierarchy_level2;

select * from FIELD_INSTALLATION_MASTER where level_1id='29';

delete from hierarchy_level2 where level1_id='34'

CREATE TABLE "public".FIELD_INSTALLATION_MASTER (CIRCLEID varchar(50) not null,CONSUMER_NO varchar(50) not null,CONSUMERID VARCHAR(50) not null
,CONS_ID varchar(50),
DISCOMID varchar(50),DISCOM varchar(50),BOARDID varchar(50),BOARD varchar(50),CIRCLE varchar(50),DIVISIONID varchar(50),
DIVISION varchar(50),SUBDIVISIONID varchar(50),SUBDIVISION varchar(50),SECTIONID varchar(50),SECTION varchar(50),
REGISTRATON_ID varchar(50),NAME varchar(50),ADDR varchar(50),CONSUMER_CATEGORY varchar(50),CD_KVA float,
OFFICE_PHONE varchar(50),MOBILE_NO varchar(50),EMAIL_ADDRESS varchar(50),LOAD_TYPE varchar(50),PHASE varchar(50),
SCHEDULE_POWER varchar(50),CATEGORY varchar(50),METER_CT_TYPE varchar(50),METER_OWNERSHIP varchar(50),METER_ELEC_TYPE varchar(50),
TRANSFORMEROWNERSHIP varchar(50),TRANSFORMERSCAPACITY varchar(50),TRANSFORMERMAKE varchar(50),TRANSFER_LOCATION varchar(50),
TRANSFORMERSERIALNO varchar(50),INDEPENDENT varchar(50),METERNO varchar(50),HID varchar(50),MODEMMEIDNUMBER varchar(50),
MODEMMDN varchar(50),MODEMNUMBER varchar(50),MCC varchar(50),MNC varchar(50),LAC varchar(50),CELLID varchar(50),SQUAL varchar(50),
SRCLEV varchar(50),IMEI_NUMBER varchar(50),SIM_PROVIDER_NAME varchar(50),MODEMMANUFACTURERNAME varchar(50),LATITUDE varchar(50),
LONGITUDE varchar(50),PHOTOLOCATION varchar(50),SUBSTATION varchar(50),SUBSTATION_CODE varchar(50),FEEDER varchar(50),
FEEDER_CODE varchar(50),FEEDERTYPE varchar(50),DTNAME varchar(50),DTCODE varchar(50),PERMANENTPOLENUMBER varchar(50),
ACNO varchar(50),M_CT varchar(50),M_PT varchar(50),MF float,MAKE varchar(50),METER_SEAL_DATE varchar(50),
METER_SEAL_NO varchar(50),METER_REVOLUTION_PERMIT varchar(50),METER_MFG_DATE varchar(50),METER_DECIMAL varchar(50),
METER_DIGIT varchar(50),METER_CAPACITY varchar(50),CURRENTRATING varchar(50),VOLTAGERATING varchar(50),CONNECTIONDATE varchar(50),
METER_CHNAGE_FLAG varchar(50),PROPRIETOR_NAME varchar(50),DISTRICT varchar(50),MUNICIPALITY_VDC varchar(50),WARD_NO varchar(50),
CITIZENSHIP_NO varchar(50),CITIZENSHIP_ISSUED_DIST varchar(50),SUPPLY_VOLTAGE varchar(50),MF_KVA varchar(50),
VERSION_NUMBER varchar(50),CREATEDDATE varchar(50),STATUS varchar(50),FLAG1 varchar(50),FLAG2 varchar(50),
BILL_DATE varchar(50),USSD_CODE varchar(50),OFF_SET varchar(50),constraint pk_INSTALLATION_MASTER primary key 
(CIRCLEID,CONSUMER_NO,CONSUMERID)
);


alter table FIELD_INSTALLATION_MASTER alter column CONSUMERID VARCHAR(50);

