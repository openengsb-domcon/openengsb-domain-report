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

import java.util.Arrays;
import java.util.List;

import org.openengsb.core.api.model.OpenEngSBModelEntry;
import org.openengsb.domain.report.model.ReportPart;

public class SimpleReportPart implements ReportPart {
    private String partName;
    private String contentType;
    private byte[] content;

    public SimpleReportPart(String partName, String contentType, byte[] content) {
        this.partName = partName;
        this.contentType = contentType;
        this.content = content;
    }

    @Override
    public byte[] getContent() {
        if (content == null) {
            return null;
        }
        return Arrays.copyOf(content, content.length);
    }

    @Override
    public void setPartName(String partName) {
        this.partName = partName;
    }

    @Override
    public String getPartName() {
        return partName;
    }

    @Override
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void addOpenEngSBModelEntry(OpenEngSBModelEntry arg0) {
    }

    @Override
    public List<OpenEngSBModelEntry> getOpenEngSBModelEntries() {
        return null;
    }

    @Override
    public void removeOpenEngSBModelEntry(String arg0) {
    }
}
