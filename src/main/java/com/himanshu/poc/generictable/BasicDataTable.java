/*
 * Copyright 2013 Himanshu Bhardwaj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
*/
package com.himanshu.poc.generictable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BasicDataTable implements DataTableInterface {

	String[] headerRows;
	Object[][] dataArr;
	int currentPage = 1;
	int numberOfPages;
	int rowsPerPage = 10;
	int[] rowsPerPageOptions = {10, 20, 30};
	Object[][] rowsToDisplay;
	boolean firstEnabled;
	boolean lastEnabled;
	boolean previousEnabled;
	boolean nextEnabled;

	@Override
	public abstract String[] getHeaderRows();

	@Override
	public abstract Object[][] getDataArr();

	public void setHeaderRows(String[] headerRows) {
		this.headerRows = headerRows;
	}

	public void setDataArr(Object[][] dataArr) {
		this.dataArr = dataArr;
	}

	@Override
	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public int getNumberOfPages() {
		int numberOfPages = getDataArr().length/rowsPerPage;
		if (getDataArr().length%rowsPerPage > 0) {
			numberOfPages ++;
		}
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Override
	public int getRowsPerPage() {
		return this.rowsPerPage;
	}

	public void setRowsPerPage(int rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
	}

	@Override
	public int[] getRowsPerPageOptions() {
		return this.rowsPerPageOptions;
	}

	public void setRowsPerPageOptions(int[] rowsPerPageOptions) {
		this.rowsPerPageOptions = rowsPerPageOptions;
	}

	public Object[][] getRowsToDisplay() {
		return rowsToDisplay;
	}

	public void setRowsToDisplay(Object[][] rowsToDisplay) {
		this.rowsToDisplay = rowsToDisplay;
	}

	public boolean isFirstEnabled() {
		return firstEnabled;
	}

	public void setFirstEnabled(boolean firstEnabled) {
		this.firstEnabled = firstEnabled;
	}

	public boolean isLastEnabled() {
		return lastEnabled;
	}

	public void setLastEnabled(boolean lastEnabled) {
		this.lastEnabled = lastEnabled;
	}

	public boolean isPreviousEnabled() {
		return previousEnabled;
	}

	public void setPreviousEnabled(boolean previousEnabled) {
		this.previousEnabled = previousEnabled;
	}

	public boolean isNextEnabled() {
		return nextEnabled;
	}

	public void setNextEnabled(boolean nextEnabled) {
		this.nextEnabled = nextEnabled;
	}

	public void displayData() {
		List<Object[]> data = Arrays.asList(getDataArr());
		List<Object[]> listToDisplay;

		int currentPageActualVal = currentPage -1;

		if ( (data.size() >= ((rowsPerPage*currentPageActualVal)+1)) &&  (data.size() > (rowsPerPage*(currentPageActualVal+1))) ) {
			listToDisplay = data.subList(rowsPerPage*currentPageActualVal, rowsPerPage*(currentPageActualVal+1) );
		} else if ( (data.size() >= ((rowsPerPage*currentPageActualVal)+1)) &&  (data.size() <= (rowsPerPage*(currentPageActualVal+1))) ) {
			listToDisplay = data.subList(rowsPerPage*currentPageActualVal, data.size() );
		} else if ( (data.size() < ((rowsPerPage*currentPageActualVal)+1)) &&  (data.size() > (rowsPerPage*(currentPageActualVal+1))) ) {
			//NOT POSSIBLE
			listToDisplay = new ArrayList<>();
		} else if ( (data.size() < ((rowsPerPage*currentPageActualVal)+1)) &&  (data.size() < (rowsPerPage*(currentPageActualVal+1))) ) {
			//NOT POSSIBLE
			listToDisplay = new ArrayList<>();
		} else {
			listToDisplay = data;
		}

		rowsToDisplay = new Object[][] {};
		rowsToDisplay = listToDisplay.toArray(rowsToDisplay);
		if(currentPage == 1) {
			setFirstEnabled(false);
			setPreviousEnabled(false);
		} else {
			setFirstEnabled(true);
			setPreviousEnabled(true);
		}
		if (currentPage == getNumberOfPages()) {
			setLastEnabled(false);
			setNextEnabled(false);
		} else {
			setLastEnabled(true);
			setNextEnabled(true);
		}
	}

	public void gotoPreviousPage() {
		currentPage --;
		displayData();
	}

	public void gotoNextPage() {
		currentPage ++;
		displayData();
	}

	@Override
	public void gotoFirstPage() {
		currentPage = 1;
		displayData();
	}

	@Override
	public void gotoLastPage() {
		currentPage = getNumberOfPages();
		displayData();
	}
}
