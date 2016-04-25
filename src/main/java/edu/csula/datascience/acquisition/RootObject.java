package org.gradle;

import java.util.List;

public class RootObject
	{
	    public CityJson city; 
	    public String cod; 
	    public double message; 
	    public int cnt; 
	    public List<ListJson> list; 
	    public CityJson getCity() {
			return city;
		}
		public void setCity(CityJson city) {
			this.city = city;
		}
		public String getCod() {
			return cod;
		}
		public void setCod(String cod) {
			this.cod = cod;
		}
		public double getMessage() {
			return message;
		}
		public void setMessage(double message) {
			this.message = message;
		}
		public int getCnt() {
			return cnt;
		}
		public void setCnt(int cnt) {
			this.cnt = cnt;
		}
		public List<ListJson> getList() {
			return list;
		}
		public void setList(List<ListJson> list) {
			this.list = list;
		}
		
	}

