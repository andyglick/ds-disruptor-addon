/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.os890.ds.addon.test.uc005;

import org.os890.ds.addon.async.event.api.ObservesAsynchronous;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class EventObserver2
{
    private AtomicInteger count = new AtomicInteger();
    private AtomicLong lastTouch = new AtomicLong(0);

    public void onEvent(@ObservesAsynchronous TestEvent event)
    {
        if (count.incrementAndGet() == SimpleBenchmarkTest.EVENT_COUNT)
        {
            lastTouch.set(System.currentTimeMillis());
        }
    }

    public void reset()
    {
        lastTouch.set(0);
        count.set(0);
    }

    public long getLastTouch()
    {
        return lastTouch.get();
    }
}
