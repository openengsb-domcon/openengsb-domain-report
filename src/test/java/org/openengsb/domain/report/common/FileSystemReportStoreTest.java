/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openengsb.domain.report.common;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.openengsb.core.api.ekb.EngineeringKnowledgeBaseService;
import org.openengsb.domain.report.model.Report;

public class FileSystemReportStoreTest extends ReportStoreTest {

    private File rootDir;

    @Override
    public ReportStore getReportStore() {
        rootDir = new File("reports");
        FileSystemReportStore store = new FileSystemReportStore(rootDir);
        
        EngineeringKnowledgeBaseService ekbService = mock(EngineeringKnowledgeBaseService.class);
        doAnswer(new Answer<java.lang.Object>() {
            public java.lang.Object answer(InvocationOnMock invocation) {
                return new TestReport("");
            }
        })
            .when(ekbService).createEmptyModelObject(Report.class);
        
        store.setEkbService(ekbService);
        
        return store;
    }

    @Override
    public void clearStore() throws Exception {
        FileUtils.deleteDirectory(rootDir);
    }

}
