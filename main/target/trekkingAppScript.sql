;             
CREATE USER IF NOT EXISTS "" SALT '' HASH '' ADMIN;           
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_16BC4D25_96AC_4F3C_9C30_3501C734838A" START WITH 8 BELONGS_TO_TABLE;
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_6EE3760A_495A_44DE_ACE2_776951D664BD" START WITH 10 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_1EA35271_20C2_495F_A078_1B7AF6BA9C20" START WITH 276 BELONGS_TO_TABLE;              
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_88C6283F_3CE2_46D0_B499_F66F9F13FB2F" START WITH 85 BELONGS_TO_TABLE;               
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_27429962_7DB5_4DF7_81E9_B5C7E1288E77" START WITH 200 BELONGS_TO_TABLE;              
CREATE SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A12BCD6D_AA8F_49B5_9354_63F93EBE82CB" START WITH 7 BELONGS_TO_TABLE;
CREATE CACHED TABLE "PUBLIC"."ITEMS"(
    "ITEM_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_27429962_7DB5_4DF7_81E9_B5C7E1288E77" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_27429962_7DB5_4DF7_81E9_B5C7E1288E77",
    "ITEM_NAME" VARCHAR(255) NOT NULL,
    "ITEM_WEIGHT" FLOAT DEFAULT '0' NOT NULL,
    "ITEM_VOLUME" FLOAT DEFAULT '0',
    "ITEM_DESCRIPTION" VARCHAR(255)
);      
ALTER TABLE "PUBLIC"."ITEMS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4" PRIMARY KEY("ITEM_ID");   
-- 6 +/- SELECT COUNT(*) FROM PUBLIC.ITEMS;   
INSERT INTO "PUBLIC"."ITEMS" VALUES
(1, STRINGDECODE('\u043d\u043e\u0436 \u043a\u0443\u0445\u043e\u043d\u043d\u044b\u0439'), 3.0, 0.10000000149011612, ''),
(3, STRINGDECODE('\u0421\u043f\u0430\u043b\u044c\u043d\u0438\u043a \u043e\u0441\u0435\u043d\u043d\u0438\u0439'), 1.0, 0.30000001192092896, STRINGDECODE('\u0440\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u043d \u043d\u0430 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0443 -20')),
(7, STRINGDECODE('\u0421\u043f\u0430\u043b\u044c\u043d\u0438\u043a \u0437\u0438\u043c\u043d\u0438\u0439'), 1.0, 0.30000001192092896, STRINGDECODE('\u0440\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u043d \u043d\u0430 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0443 -20')),
(11, STRINGDECODE('\u0428\u0430\u043f\u043a\u0430 \u0433\u043e\u0440\u043d\u043e\u043b\u044b\u0436\u043d\u0430\u044f'), 1.0, 0.30000001192092896, STRINGDECODE('\u0440\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u043d\u0430 \u043d\u0430 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0443 -20')),
(12, STRINGDECODE('\u0428\u0430\u043f\u043a\u0430 \u0433\u043e\u0440\u043d\u043e\u043b\u044b\u0436\u043d\u0430\u044f'), 1.0, 0.30000001192092896, STRINGDECODE('\u0440\u0430\u0441\u0441\u0447\u0438\u0442\u0430\u043d\u0430 \u043d\u0430 \u0442\u0435\u043c\u043f\u0435\u0440\u0430\u0442\u0443\u0440\u0443 -20')),
(133, STRINGDECODE('\u043f\u0430\u043b\u0430\u0442\u043a\u0430'), 5.0, 0.0, STRINGDECODE('\u043f\u0430\u043b\u0430\u0442\u043a\u0430'));
CREATE CACHED TABLE "PUBLIC"."EQUIPMENT"(
    "ITEM_ID" INT NOT NULL,
    "EQUIPMENT_TYPE_ID" INT NOT NULL
);              
-- 7 +/- SELECT COUNT(*) FROM PUBLIC.EQUIPMENT;               
INSERT INTO "PUBLIC"."EQUIPMENT" VALUES
(3, 7),
(3, 7),
(3, 1),
(3, 1),
(7, 2),
(7, 2),
(7, 2);        
CREATE CACHED TABLE "PUBLIC"."EQUIPMENT_TYPE"(
    "EQUIPMENT_TYPE_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_6EE3760A_495A_44DE_ACE2_776951D664BD" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_6EE3760A_495A_44DE_ACE2_776951D664BD",
    "EQUIPMENT_TYPE_NAME" VARCHAR(255) NOT NULL,
    "MAX_WEIGHT" INT DEFAULT '0',
    "PURPOSE" VARCHAR(255),
    "DESCRIPTION" VARCHAR(255)
);   
ALTER TABLE "PUBLIC"."EQUIPMENT_TYPE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F" PRIMARY KEY("EQUIPMENT_TYPE_ID");
-- 8 +/- SELECT COUNT(*) FROM PUBLIC.EQUIPMENT_TYPE;          
INSERT INTO "PUBLIC"."EQUIPMENT_TYPE" VALUES
(1, 'WINTERKIT', 22, 'FOR WINTER', 'BIG'),
(2, 'GG', 22, NULL, 'GG'),
(3, 'name', 222, 'purpose', 'description'),
(4, 'hh', 55, 'hh', 'hh'),
(5, 'HH', 22, NULL, 'GG'),
(6, 'ff', 22, NULL, 'ff'),
(7, 'BG', 33, NULL, 'GG'),
(8, 'ff', 22, 'ff', 'ff'); 
CREATE CACHED TABLE "PUBLIC"."PRODUCTS"(
    "PRODUCT_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_88C6283F_3CE2_46D0_B499_F66F9F13FB2F" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_88C6283F_3CE2_46D0_B499_F66F9F13FB2F",
    "PRODUCT_NAME" VARCHAR(45) NOT NULL,
    "PRODUCT_WEIGHT" FLOAT NOT NULL,
    "PRODUCT_CALORIES" INT NOT NULL,
    "PRODUCT_PROTEINS" FLOAT NOT NULL,
    "PRODUCT_FATS" FLOAT NOT NULL,
    "PRODUCT_CARBOHYDRATES" FLOAT NOT NULL,
    "PRODUCT_DESCRIPTION" VARCHAR(255)
);           
ALTER TABLE "PUBLIC"."PRODUCTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_F2" PRIMARY KEY("PRODUCT_ID");            
-- 46 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCTS;               
INSERT INTO "PUBLIC"."PRODUCTS" VALUES
(37, STRINGDECODE('\u043f\u043e\u0434\u0441\u043e\u043b\u043d\u0435\u0447\u043d\u043e\u0435 \u043c\u0430\u0441\u043b\u043e'), 20.0, 176, 0.0, 18.979999542236328, 0.0, NULL),
(38, STRINGDECODE('\u041c\u0430\u0441\u043b\u043e \u0441\u043b\u0438\u0432\u043e\u0447\u043d\u043e\u0435 \u043d\u0435\u0441\u043e\u043b\u0435\u043d\u043e\u0435'), 20.0, 147, 0.07999999821186066, 15.699999809265137, 0.10000000149011612, NULL),
(39, STRINGDECODE('\u041c\u0430\u0441\u043b\u043e \u0442\u043e\u043f\u043b\u0435\u043d\u043e\u0435'), 20.0, 174, 0.0, 18.700000762939453, 12.899999618530273, NULL),
(40, STRINGDECODE('\u0421\u044b\u0440, 50% \u0436\u0438\u0440\u043d\u043e\u0441\u0442\u0438'), 25.0, 95, 5.349999904632568, 7.579999923706055, 0.6299999952316284, NULL),
(41, STRINGDECODE('\u041c\u043e\u043b\u043e\u043a\u043e \u0441\u0443\u0445\u043e\u0435'), 50.0, 240, 5.349999904632568, 7.579999923706055, 0.6299999952316284, NULL),
(42, STRINGDECODE('\u042f\u0438\u0447\u043d\u044b\u0439 \u043f\u043e\u0440\u043e\u0448\u043e\u043a'), 5.0, 26, 2.490000009536743, 1.7100000381469727, 0.0, NULL),
(43, STRINGDECODE('\u041a\u043e\u043b\u0431\u0430\u0441\u0430 \u0441\u044b\u0440\u043e\u043a\u043e\u043f\u0447\u0435\u043d\u0430\u044f'), 25.0, 108, 5.099999904632568, 9.350000381469727, 0.0, NULL),
(44, STRINGDECODE('\u041a\u043e\u0440\u0435\u0439\u043a\u0430 \u043a\u043e\u043f\u0447\u0435\u043d\u0430\u044f'), 25.0, 137, 2.630000114440918, 13.5, 0.0, NULL),
(45, STRINGDECODE('\u041c\u044f\u0441\u043e \u043a\u043e\u043d\u0441\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u043e\u0435'), 50.0, 56, 7.5, 8.5, 0.3499999940395355, NULL),
(46, STRINGDECODE('\u041f\u0430\u0448\u0442\u0435\u0442 \u043a\u043e\u043d\u0441\u0435\u0440\u0432\u043d\u044b\u0439 \u043f\u0435\u0447\u0435\u043d\u043e\u0447\u043d\u044b\u0439'), 25.0, 76, 3.9000000953674316, 6.300000190734863, 0.25, NULL),
(47, STRINGDECODE('\u0421\u0432\u0438\u043d\u0438\u043d\u0430(\u043a\u0430\u0440\u0431\u043e\u043d\u0430\u0442, \u0440\u0443\u043b\u0435\u0442) \u0441\u0443\u0431\u043b\u0438\u043c\u0438\u0440.'), 35.0, 168, 28.489999771118164, 5.599999904632568, 0.0, NULL),
(48, STRINGDECODE('\u0424\u0430\u0440\u0448 \u043c\u044f\u0441\u043d\u043e\u0439 \u0441\u0443\u0431\u043b\u0438\u043c\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0439'), 40.0, 220, 30.0, 8.0, 0.0, NULL),
(49, STRINGDECODE('\u0412\u043e\u0431\u043b\u0430 \u0441\u0443\u0448\u0435\u043d\u0430\u044f'), 15.0, 34, 6.429999828338623, 0.8700000047683716, 0.0, NULL),
(50, STRINGDECODE('\u0420\u044b\u0431\u0430 \u043a\u043e\u043d\u0441\u0435\u0440\u0432\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u0430\u044f \u0432 \u043c\u0430\u0441\u043b\u0435'), 20.0, 125, 0.800000011920929, 12.5, 0.30000001192092896, NULL),
(51, STRINGDECODE('\u0413\u043e\u0440\u043e\u0445'), 10.0, 29, 1.5700000524520874, 0.2199999988079071, 5.010000228881836, NULL),
(52, STRINGDECODE('\u0413\u0440\u0435\u0447\u043a\u0430'), 15.0, 48, 1.3200000524520874, 0.3400000035762787, 9.510000228881836, NULL),
(53, STRINGDECODE('\u041c\u0430\u043a\u0430\u0440\u043e\u043d\u044b, \u043b\u0430\u043f\u0448\u0430, \u0432\u0435\u0440\u043c\u0438\u0448\u0435\u043b\u044c'), 15.0, 50, 1.399999976158142, 0.11999999731779099, 10.640000343322754, NULL),
(54, STRINGDECODE('\u041c\u0430\u043d\u043a\u0430'), 10.0, 33, 0.949999988079071, 0.07000000029802322, 7.039999961853027, NULL),
(55, STRINGDECODE('\u041e\u0432\u0441\u044f\u043d\u043a\u0430'), 10.0, 34, 0.8899999856948853, 0.5899999737739563, 5.980000019073486, NULL),
(56, STRINGDECODE('\u041a\u0440\u0443\u043f\u0430 \u043f\u0435\u0440\u043b\u043e\u0432\u0430\u044f'), 10.0, 31, 0.6299999952316284, 0.11999999731779099, 6.619999885559082, NULL),
(57, STRINGDECODE('\u041a\u0440\u0443\u043f\u0430 \u043f\u0448\u0435\u043d\u043d\u0430\u044f'), 10.0, 32, 0.8399999737739563, 0.23000000417232513, 6.239999771118164, NULL),
(58, STRINGDECODE('\u041a\u0440\u0443\u043f\u0430 \u0440\u0438\u0441\u043e\u0432\u0430\u044f'), 10.0, 33, 0.6700000166893005, 0.09000000357627869, 7.28000020980835, NULL),
(59, STRINGDECODE('\u0422\u043e\u043b\u043e\u043a\u043d\u043e'), 10.0, 36, 1.159999966621399, 0.5899999737739563, 6.269999980926514, NULL);             
INSERT INTO "PUBLIC"."PRODUCTS" VALUES
(60, STRINGDECODE('\u041a\u0440\u0443\u043f\u0430 \u044f\u0447\u043d\u0435\u0432\u0430\u044f'), 10.0, 31, 0.6299999952316284, 0.11999999731779099, 6.619999885559082, NULL),
(61, STRINGDECODE('\u0421\u0443\u043f\u044b \u0432 \u043f\u0430\u043a\u0435\u0442\u0430\u0445'), 50.0, 200, 1.5, 2.5, 5.0, NULL),
(62, STRINGDECODE('\u041a\u0430\u0440\u0442\u043e\u0444\u0435\u043b\u044c \u0441\u0443\u0448\u0435\u043d\u044b\u0439 \u0438\u043b\u0438 \u043a\u0440\u0443\u043f\u043a\u0430'), 15.0, 47, 0.9100000262260437, 0.0, 10.84000015258789, NULL),
(63, STRINGDECODE('\u041b\u0443\u043a \u0440\u0435\u043f\u0447\u0430\u0442\u044b\u0439'), 5.0, 2, 0.10000000149011612, 0.0, 0.44999998807907104, NULL),
(64, STRINGDECODE('\u0427\u0435\u0441\u043d\u043e\u043a'), 5.0, 6, 0.27000001072883606, 0.0, 1.0800000429153442, NULL),
(65, STRINGDECODE('\u0413\u043b\u044e\u043a\u043e\u0437\u0430 \u0441 \u0432\u0438\u0442\u0430\u043c\u0438\u043d\u0430\u043c\u0438'), 20.0, 81, 0.0, 0.0, 19.799999237060547, NULL),
(66, STRINGDECODE('\u041a\u0430\u0440\u0430\u043c\u0435\u043b\u044c \u043b\u0435\u0434\u0435\u043d\u0446\u043e\u0432\u0430\u044f'), 40.0, 143, 0.0, 0.0, 35.68000030517578, NULL),
(67, STRINGDECODE('\u0421\u0430\u0445\u0430\u0440'), 120.0, 480, 0.0, 0.0, 119.76000213623047, NULL),
(68, STRINGDECODE('\u0425\u0430\u043b\u0432\u0430 \u043f\u043e\u0434\u0441\u043e\u043b\u043d\u0435\u0447\u043d\u0430\u044f'), 30.0, 152, 5.639999866485596, 9.449999809265137, 11.010000228881836, NULL),
(69, STRINGDECODE('\u0418\u0437\u044e\u043c'), 25.0, 73, 0.44999998807907104, 0.0, 17.729999542236328, NULL),
(70, STRINGDECODE('\u041e\u0440\u0435\u0445\u0438 \u0433\u0440\u0435\u0446\u043a\u0438\u0435'), 25.0, 155, 3.4000000953674316, 14.0, 2.9200000762939453, NULL),
(71, STRINGDECODE('\u041a\u0430\u043a\u0430\u043e \u043f\u043e\u0440\u043e\u0448\u043e\u043a'), 5.0, 18, 1.1799999475479126, 1.0099999904632568, 0.8899999856948853, NULL),
(72, STRINGDECODE('\u041a\u0438\u0441\u0435\u043b\u044c \u0444\u0440\u0443\u043a\u0442\u043e\u0432\u043e-\u044f\u0433\u043e\u0434\u043d\u044b\u0439 \u0441\u0443\u0445\u043e\u0439'), 15.0, 15, 0.029999999329447746, 0.0, 2.5999999046325684, NULL),
(73, STRINGDECODE('\u041a\u043e\u0444\u0435 \u0440\u0430\u0441\u0442\u0432\u043e\u0440\u0438\u043c\u044b\u0439'), 5.0, 15, 0.18000000715255737, 0.18000000715255737, 0.0, NULL),
(74, STRINGDECODE('\u0427\u0430\u0439'), 5.0, 0, 0.18000000715255737, 0.18000000715255737, 0.0, NULL),
(75, STRINGDECODE('\u0413\u0430\u043b\u0435\u0442\u044b'), 25.0, 84, 3.1700000762939453, 0.0, 17.200000762939453, NULL),
(76, STRINGDECODE('\u041f\u0435\u0447\u0435\u043d\u044c\u0435 \u0441\u0443\u0445\u043e\u0435'), 25.0, 106, 3.0, 3.6500000953674316, 14.600000381469727, NULL),
(77, STRINGDECODE('\u0421\u0443\u0445\u0430\u0440\u0438 \u043f\u0448\u0435\u043d\u0438\u0447\u043d\u044b\u0435'), 30.0, 100, 3.1500000953674316, 0.36000001430511475, 20.549999237060547, NULL),
(78, STRINGDECODE('\u0421\u0443\u0445\u0430\u0440\u0438 \u0440\u0436\u0430\u043d\u044b\u0435'), 70.0, 214, 5.389999866485596, 0.9100000262260437, 44.869998931884766, NULL),
(79, STRINGDECODE('\u041b\u0430\u0432\u0440\u043e\u0432\u044b\u0439 \u043b\u0438\u0441\u0442'), 1.0, 0, 0.0, 0.0, 0.0, NULL),
(80, STRINGDECODE('\u0421\u043e\u043b\u044c'), 10.0, 0, 0.0, 0.0, 0.0, NULL),
(81, STRINGDECODE('\u0422\u043e\u043c\u0430\u0442\u043d\u0430\u044f \u043f\u0430\u0441\u0442\u0430'), 8.0, 6, 0.2800000011920929, 0.0, 1.2000000476837158, NULL),
(84, STRINGDECODE('\u0441\u043c\u0435\u0442\u0430\u043d\u0430'), 4.0, 4, 4.0, 4.0, 4.0, STRINGDECODE('\u0441\u043c\u0435\u0442\u0430\u043d\u0430'));             
CREATE CACHED TABLE "PUBLIC"."PRODUCT_MENU_TYPES"(
    "PRODUCT_MENU_TYPE_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_A12BCD6D_AA8F_49B5_9354_63F93EBE82CB" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_A12BCD6D_AA8F_49B5_9354_63F93EBE82CB",
    "PRODUCT_MENU_TYPE_NAME" VARCHAR(255) NOT NULL,
    "PRODUCT_MENU_TYPE_WEIGHT" INT NOT NULL,
    "PRODUCT_MENU_TYPE_CALORIES" INT NOT NULL,
    "PRODUCT_MENU_TYPE_PROTEINS" FLOAT NOT NULL,
    "PRODUCT_MENU_TYPE_FATS" FLOAT NOT NULL,
    "PRODUCT_MENU_TYPE_CARBOHYDRATES" FLOAT NOT NULL,
    "PRODUCT_MENU_TYPE_DESCRIPTION" VARCHAR(255) NOT NULL
);         
ALTER TABLE "PUBLIC"."PRODUCT_MENU_TYPES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("PRODUCT_MENU_TYPE_ID");         
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT_MENU_TYPES;      
INSERT INTO "PUBLIC"."PRODUCT_MENU_TYPES" VALUES
(1, 'YY', 9, 9, 9.0, 9.0, 9.0, 'UU'),
(3, STRINGDECODE('\u0435\u0435'), 44, 44, 44.0, 44.0, 44.0, STRINGDECODE('\u0435\u0435')),
(4, STRINGDECODE('\u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u044b\u0439 \u043f\u0440\u043e\u0434\u0443\u043a\u0442\u043e\u0432\u044b\u0439 \u043d\u0430\u0431\u043e\u0440 \u0434\u043b\u044f \u043f\u0435\u0448\u0435\u0433\u043e \u043f\u043e\u0445\u043e\u0434\u0430 \u0432\u044b\u0445\u043e\u0434\u043d\u043e\u0433\u043e \u0434\u043d\u044f, 1 \u0434\u0435\u043d\u044c'), 0, 0, 0.0, 0.0, 0.0, STRINGDECODE('\u043e\u0431\u0440\u0430\u0437\u0435\u0446'));           
CREATE CACHED TABLE "PUBLIC"."PRODUCT_MENU"(
    "PRODUCT_ID" INT NOT NULL,
    "PRODUCT_MENU_TYPE_ID" INT NOT NULL
);     
-- 453 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT_MENU;          
INSERT INTO "PUBLIC"."PRODUCT_MENU" VALUES
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(37, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(38, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(39, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(40, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(41, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(42, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(43, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(44, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(45, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(46, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(47, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(48, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(49, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(50, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(51, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(52, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(53, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(54, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(55, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(56, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(57, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(58, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(59, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(60, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(61, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(62, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(63, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(64, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(65, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(66, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(67, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(68, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(69, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(70, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(71, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(72, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(73, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(74, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(75, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(76, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(77, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(78, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(79, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(80, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(81, 4),
(37, 1);      
INSERT INTO "PUBLIC"."PRODUCT_MENU" VALUES
(37, 1),
(37, 1);
CREATE CACHED TABLE "PUBLIC"."ROUTE_TYPES"(
    "ROUTE_TYPE_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_16BC4D25_96AC_4F3C_9C30_3501C734838A" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_16BC4D25_96AC_4F3C_9C30_3501C734838A",
    "ROUTE_TYPE_NAME" VARCHAR(255) NOT NULL,
    "ROUTE_TYPE_STARTX" DOUBLE NOT NULL,
    "ROUTE_TYPE_STARTY" DOUBLE NOT NULL,
    "ROUTE_TYPE_FINISHX" DOUBLE NOT NULL,
    "ROUTE_TYPE_FINISHY" DOUBLE NOT NULL,
    "ROUTE_TYPE_DISTANCE" FLOAT NOT NULL,
    "ROUTE_TYPE_DESCRIPTION" VARCHAR(255) NOT NULL,
    "ROUTE_TYPE_DURATION" FLOAT NOT NULL
);          
ALTER TABLE "PUBLIC"."ROUTE_TYPES" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_4D" PRIMARY KEY("ROUTE_TYPE_ID");      
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.ROUTE_TYPES;             
INSERT INTO "PUBLIC"."ROUTE_TYPES" VALUES
(1, 'Summer_hiking', 23.87574, 75.8576, 76.8564, 87.83475, 67.0, 'very long route', 85.0),
(4, 'AutumnRoute', 75.5985, 65.7563, 0.0, 75.7585, 45.0, 'old route', 2.0),
(7, STRINGDECODE('\u0421\u043c\u0430\u0440\u0442-\u043c\u0430\u0440\u0448\u0440\u0443\u0442'), 55.9695654, 38.3818935, 55.9630322, 38.4035228, 2.1018970012664795, STRINGDECODE('\u0421\u043c\u0430\u0440\u0442-\u043c\u0430\u0440\u0448\u0440\u0443\u0442'), 0.21018968522548676);       
CREATE CACHED TABLE "PUBLIC"."GROUPS"(
    "CLIENT_ID" INT NOT NULL,
    "ROUTE_TYPE_ID" INT NOT NULL
);   
-- 6 +/- SELECT COUNT(*) FROM PUBLIC."GROUPS";
INSERT INTO "PUBLIC"."GROUPS" VALUES
(3, 4),
(3, 4),
(3, 4),
(3, 1),
(3, 1),
(3, 1);    
CREATE CACHED TABLE "PUBLIC"."CLIENTS"(
    "CLIENT_ID" INT DEFAULT NEXT VALUE FOR "PUBLIC"."SYSTEM_SEQUENCE_1EA35271_20C2_495F_A078_1B7AF6BA9C20" NOT NULL NULL_TO_DEFAULT SEQUENCE "PUBLIC"."SYSTEM_SEQUENCE_1EA35271_20C2_495F_A078_1B7AF6BA9C20",
    "CLIENT_SURNAME" VARCHAR(255) DEFAULT 'SURNAME' NOT NULL,
    "CLIENT_NAME" VARCHAR(255) DEFAULT 'NAME' NOT NULL,
    "CLIENT_PATRONIMIC" VARCHAR(255) DEFAULT 'PATRONIMIC' NOT NULL,
    "CLIENT_AGE" INT NOT NULL,
    "CLIENT_PASSPORT_SERIAL" INT NOT NULL,
    "CLIENT_PASSPORT_NUMBER" DOUBLE NOT NULL,
    "CLIENT_PHONE" VARCHAR(255) NOT NULL,
    "CLIENT_EMAIL" VARCHAR(255),
    "CLIENT_DESCRIPTION" VARCHAR(255)
);        
ALTER TABLE "PUBLIC"."CLIENTS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("CLIENT_ID");               
-- 3 +/- SELECT COUNT(*) FROM PUBLIC.CLIENTS; 
INSERT INTO "PUBLIC"."CLIENTS" VALUES
(3, 'che', 'Germniy', 'Sigizmundovich', 55, 2015, 883965.0, '89204636169', 'Polonskiy@yandex.ru', STRINGDECODE('\u041d\u043e\u0432\u044b\u0439 \u043a\u043b\u0438\u0435\u043d\u0442, \u043e\u0447\u0435\u043d\u044c \u0442\u0440\u0435\u0431\u043e\u0432\u0430\u0442\u0435\u043b\u044c\u043d\u044b\u0439')),
(49, 'chu', 'pavlov', 'nikolaevich', 55, 55, 55.0, '55', '55', '55'),
(146, 'gh', 'gh', 'gh', 44, 44, 44.0, '44', 'gh', 'gh');          
ALTER TABLE "PUBLIC"."EQUIPMENT" ADD CONSTRAINT "PUBLIC"."EQUIPMENT_FK1" FOREIGN KEY("EQUIPMENT_TYPE_ID") REFERENCES "PUBLIC"."EQUIPMENT_TYPE"("EQUIPMENT_TYPE_ID") NOCHECK;  
ALTER TABLE "PUBLIC"."EQUIPMENT" ADD CONSTRAINT "PUBLIC"."EQUIPMENT_FK0" FOREIGN KEY("ITEM_ID") REFERENCES "PUBLIC"."ITEMS"("ITEM_ID") NOCHECK;               
ALTER TABLE "PUBLIC"."PRODUCT_MENU" ADD CONSTRAINT "PUBLIC"."PRODUCT_MENU_FK1" FOREIGN KEY("PRODUCT_MENU_TYPE_ID") REFERENCES "PUBLIC"."PRODUCT_MENU_TYPES"("PRODUCT_MENU_TYPE_ID") NOCHECK;  
ALTER TABLE "PUBLIC"."PRODUCT_MENU" ADD CONSTRAINT "PUBLIC"."PRODUCT_MENU_FK0" FOREIGN KEY("PRODUCT_ID") REFERENCES "PUBLIC"."PRODUCTS"("PRODUCT_ID") NOCHECK;
ALTER TABLE "PUBLIC"."GROUPS" ADD CONSTRAINT "PUBLIC"."GROUPES_FK0" FOREIGN KEY("CLIENT_ID") REFERENCES "PUBLIC"."CLIENTS"("CLIENT_ID") NOCHECK;              
ALTER TABLE "PUBLIC"."GROUPS" ADD CONSTRAINT "PUBLIC"."GROUPES_FK1" FOREIGN KEY("ROUTE_TYPE_ID") REFERENCES "PUBLIC"."ROUTE_TYPES"("ROUTE_TYPE_ID") NOCHECK;  
