package org.bkr.web;

import java.math.BigDecimal;


public class TDetail {

	private long templateId;
	private long masterBreadId;
	
	private THeader head;

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public long getMasterBreadId() {
		return masterBreadId;
	}

	public void setMasterBreadId(long masterBreadId) {
		this.masterBreadId = masterBreadId;
	}

	public THeader getHead() {
		return head;
	}

	public void setHead(THeader head) {
		this.head = head;
	}
	
	
	
}
