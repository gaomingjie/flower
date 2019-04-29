/**
 * Copyright © 2019 同程艺龙 (zhihui.li@ly.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ly.train.flower.common.filter.impl;

import org.junit.Test;
import com.ly.train.flower.base.TestBase;
import com.ly.train.flower.base.model.User;
import com.ly.train.flower.base.service.OpenTracerService;
import com.ly.train.flower.base.service.ServiceA;
import com.ly.train.flower.base.service.ServiceB;
import com.ly.train.flower.base.service.ServiceC1;
import com.ly.train.flower.common.akka.FlowRouter;
import com.ly.train.flower.common.service.container.ServiceFlow;

/**
 * @author leeyazhou
 */
public class OpentracingFilterTest extends TestBase {

  @Test
  public void testSyncCallServiceSimple() throws Exception {
    ServiceFlow serviceFlow = serviceFactory.getOrCreateServiceFlow(flowName);
    serviceFlow.buildFlow(ServiceA.class, ServiceB.class);
    serviceFlow.buildFlow(ServiceB.class, ServiceC1.class);
    serviceFlow.buildFlow(ServiceC1.class, OpenTracerService.class);
    final FlowRouter router = serviceFacade.buildFlowRouter(flowName, 2 << 3);

    User user = new User();
    user.setName("响应式编程 ");
    user.setAge(2);
    Object o = router.syncCallService(user);
    System.out.println("响应结果： " + o);
    Thread.sleep(1000);
  }

}
