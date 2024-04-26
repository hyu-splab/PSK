file://<WORKSPACE>/examples/src/main/java/kafka/examples/ConsumerDemo.java
### java.util.NoSuchElementException: next on empty iterator

occurred in the presentation compiler.

presentation compiler configuration:
Scala version: 3.3.3
Classpath:
<HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala3-library_3/3.3.3/scala3-library_3-3.3.3.jar [exists ], <HOME>/.cache/coursier/v1/https/repo1.maven.org/maven2/org/scala-lang/scala-library/2.13.12/scala-library-2.13.12.jar [exists ]
Options:



action parameters:
uri: file://<WORKSPACE>/examples/src/main/java/kafka/examples/ConsumerDemo.java
text:
```scala
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kafka.examples;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * This example can be decomposed into the following stages:
 * <p>
 * 1. Clean any topics left from previous runs.
 * 2. Create a producer thread to send a set of records to topic1.
 * 3. Create a consumer thread to fetch all previously sent records from topic1.
 * <p>
 * If you are using IntelliJ IDEA, the above arguments should be put in `Modify Run Configuration - Program Arguments`.
 * You can also set an output log file in `Modify Run Configuration - Modify options - Save console output to file` to
 * record all the log output together.
 */
public class ConsumerDemo {
    public static final String TOPIC_NAME = "topic1";
    public static final String GROUP_NAME = "my-group";

    public static void main(String[] args) {
        try {
            if (args.length == 0) { 
                Utils.printHelp("This example takes 2 parameters (i.e. 10000 sync):%n" +
                    "- records: total number of records to send (required)%n" +
                    "- mode: pass 'sync' to send records synchronously (optional)");
                return;
            }

            int numRecords = Integer.parseInt(args[0]); //수
            String id = args[1]; //client_id
            String Topic_name = args[2]; //topic name
            String Group_name = args[3]; //group name 
            int wait = Integer.parseInt(args[4]);
            //boolean isAsync = args.length == 1 || !args[1].trim().equalsIgnoreCase("sync");

            // stage 1: clean any topics left from previous runs
            //Utils.recreateTopics(KafkaProperties.BOOTSTRAP_SERVERS, -1, TOPIC_NAME);
            CountDownLatch latch = new CountDownLatch(2);


            // stage 3: consume records from topic1
            Consumer consumerThread = new Consumer(
                "consumer", KafkaProperties.BOOTSTRAP_SERVERS, Topic_name, Group_name, Optional.empty(), false, numRecords, latch);
            consumerThread.setClientId(id);
            consumerThread.start();

            
            if (!latch.await(wait, TimeUnit.MINUTES)) {
                Utils.printErr("Timeout after 3 minutes waiting for termination");
                //producerThread.shutdown();
                consumerThread.shutdown();
            }
            
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
```



#### Error stacktrace:

```
scala.collection.Iterator$$anon$19.next(Iterator.scala:973)
	scala.collection.Iterator$$anon$19.next(Iterator.scala:971)
	scala.collection.mutable.MutationTracker$CheckedIterator.next(MutationTracker.scala:76)
	scala.collection.IterableOps.head(Iterable.scala:222)
	scala.collection.IterableOps.head$(Iterable.scala:222)
	scala.collection.AbstractIterable.head(Iterable.scala:933)
	dotty.tools.dotc.interactive.InteractiveDriver.run(InteractiveDriver.scala:168)
	scala.meta.internal.pc.MetalsDriver.run(MetalsDriver.scala:45)
	scala.meta.internal.pc.PcCollector.<init>(PcCollector.scala:44)
	scala.meta.internal.pc.PcSemanticTokensProvider$Collector$.<init>(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector$lzyINIT1(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.Collector(PcSemanticTokensProvider.scala:61)
	scala.meta.internal.pc.PcSemanticTokensProvider.provide(PcSemanticTokensProvider.scala:90)
	scala.meta.internal.pc.ScalaPresentationCompiler.semanticTokens$$anonfun$1(ScalaPresentationCompiler.scala:110)
```
#### Short summary: 

java.util.NoSuchElementException: next on empty iterator