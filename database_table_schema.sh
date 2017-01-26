#!/usr/bin/env bash



create database assignment1;

use assignment1;

create table max_temp(no_mention int(4), weather_Station_identifier int(6), WBAN int(5), observation_date int(8), observation_hour int(4), unknown int(1),
latitute varchar(6),longitude varchar(6), FM varchar(5),elevation varchar(5), placeholder int(5), placeholder2 int(4), wind_direction int(3),quality_code int(1),
placeholder3 int(1), placeholder4 varchar(1),placeholder5 int(4),placeholder6 int(1),placeholder7 int(1),placeholder8 int(5),placeholder9 int(1),
placeholder10 varchar(1),visibility_distance int(6), quality_code1 int(1), placeholder11 varchar(1),placeholder12 int(1), air_temp int(4), quality_code2 int(1),
dew_missing varchar(5), quality_code3 int(1), atomospheric_pressure int(5), quality_code4 int(1));