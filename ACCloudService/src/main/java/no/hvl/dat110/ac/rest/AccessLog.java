package no.hvl.dat110.ac.rest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.gson.Gson;

public class AccessLog {
	
	private AtomicInteger cid;
	protected ConcurrentHashMap<Integer, AccessEntry> log;
	
	public AccessLog () {
		this.log = new ConcurrentHashMap<Integer,AccessEntry>();
		cid = new AtomicInteger(0);
	}

	// TODO: add an access entry for the message and return assigned id -- DONE
	public int add(String message) {
		int id = cid.incrementAndGet();
		log.put(id, new AccessEntry(id, message));
		return id;
	}
		
	// TODO: retrieve a specific access entry -- DONE
	public AccessEntry get(int id) {
		return log.get(id);
		
	}
	
	// TODO: clear the access entry log --DONE
	public void clear() {
		log.clear();
		cid.set(0);
	}
	
	// TODO: JSON representation of the access log -- DONE
	public String toJson () {
    	Gson gson = new Gson();
    	String json = gson.toJson(log);
    	return json;
    }
}
