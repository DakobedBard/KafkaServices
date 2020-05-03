#!/bin/bash

docker exec productDB psql -U postgres -d productdb   -c "SELECT * FROM  product_entity limit 1;"