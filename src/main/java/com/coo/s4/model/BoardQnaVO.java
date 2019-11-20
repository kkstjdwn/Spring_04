package com.coo.s4.model;

import java.util.List;

public class BoardQnaVO extends BoardVO{
	private Integer ref;
	private Integer step;
	private Integer depth;
	private List<QnaFilesVO> files;
	
	public List<QnaFilesVO> getFiles() {
		return files;
	}
	public void setFiles(List<QnaFilesVO> files) {
		this.files = files;
	}
	public Integer getRef() {
		return ref;
	}
	public void setRef(Integer ref) {
		this.ref = ref;
	}
	public Integer getStep() {
		return step;
	}
	public void setStep(Integer step) {
		this.step = step;
	}
	public Integer getDepth() {
		return depth;
	}
	public void setDepth(Integer depth) {
		this.depth = depth;
	}
}
