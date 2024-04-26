#!/bin/bash
# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
# 
#    http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

base_dir=$(dirname $0)/../..

if [ "x$KAFKA_HEAP_OPTS" = "x" ]; then
    export KAFKA_HEAP_OPTS="-Xmx512M"
fi

# ConsumerDemo1 시작 시간 기록
start_time1=$(date +%s.%3N)

# ConsumerDemo1 실행 및 출력을 임시 파일에 저장
#$base_dir/bin/kafka-run-class.sh kafka.examples.ConsumerDemo 10000 normal topicE A 1 > consumer_demo1_output.txt &
$base_dir/bin/kafka-run-class.sh kafka.examples.ConsumerDemo 10000 my_first_client topicE A 1 > consumer_demo1_output.txt &
pid1=$!

# ConsumerDemo2 시작 시간 기록
#start_time2=$(date +%s.%3N)


# ConsumerDemo2 실행 및 출력을 임시 파일에 저장
#$base_dir/bin/kafka-run-class.sh kafka.examples.ConsumerDemo 10000 my_first_client topicE B 1 > consumer_demo2_output.txt &
#$base_dir/bin/kafka-run-class.sh kafka.examples.ConsumerDemo 10000 test topicE B 1 > consumer_demo2_output.txt &
#pid2=$!

# 두 프로세스가 종료될 때까지 대기
wait $pid1

# ConsumerDemo1 종료 시간 기록
end_time1=$(date +%s.%3N)
#wait $pid2

# ConsumerDemo2 종료 시간 기록
#end_time2=$(date +%s.%3N)


# 실행 시간 계산
runtime1=$(echo "$end_time1 - $start_time1" | bc)
#runtime2=$(echo "$end_time2 - $start_time2" | bc)


# 출력을 CSV 파일로 저장
#echo "Consumer1 Output" > output1.csv
#cat consumer_demo1_output.txt >> output1.csv
#echo "" >> output1.csv
#echo "Consumer2 Output" > output2.csv
#cat consumer_demo2_output.txt >> output2.csv
#echo "" >> output2.csv


# 임시 파일 삭제
#rm consumer_demo1_output.txt consumer_demo2_output.txt

# 실행 시간 출력
#echo "Consumer1 실행 시간 (초): $runtime1"
#echo "Consumer2 실행 시간 (초): $runtime2"

echo "Consumer outputs saved to output.csv"
