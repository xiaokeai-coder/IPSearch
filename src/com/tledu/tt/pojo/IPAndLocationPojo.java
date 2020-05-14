package com.tledu.tt.pojo;

import com.tledu.tt.util.IPUtil;

public class IPAndLocationPojo implements Comparable<IPAndLocationPojo>{
	private String startIP;
	private String endIP;
	private String location;

	// 衍生字段

	private long startIPLong;
	private long endIPLong;

	public String getStartIP() {
		return startIP;
	}

	public void setStartIP(String startIP) {
		this.startIP = startIP;
	}

	public String getEndIP() {
		return endIP;
	}

	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getStartIPLong() {
		return startIPLong;
	}

	public void setStartIPLong(long startIPLong) {
		this.startIPLong = startIPLong;
	}

	public long getEndIPLong() {
		return endIPLong;
	}

	public void setEndIPLong(long endIPLong) {
		this.endIPLong = endIPLong;
	}

	public IPAndLocationPojo(String startIP, String endIP, String location) {
		super();
		this.startIP = startIP;
		this.endIP = endIP;
		this.location = location;
		this.startIPLong = IPUtil.ipToLong(startIP);
		this.endIPLong = IPUtil.ipToLong(endIP);
	}

	public IPAndLocationPojo() {
		super();
	}

	@Override
	public String toString() {
		return "IPAndLocationPojo [startIP=" + startIP + ", endIP=" + endIP
				+ ", location=" + location + ", startIPLong=" + startIPLong
				+ ", endIPLong=" + endIPLong + "]";
	}

	@Override
	public int compareTo(IPAndLocationPojo o) {
		long status = this.startIPLong - o.startIPLong;
		// if (status > 0 ) {
		// return 1;
		// }else if (status < 0) {
		// return -1;
		// }else{
		// return 0;
		// }
		return status > 0 ? 1 : (status < 0 ? - 1 : 0);
	}

}
