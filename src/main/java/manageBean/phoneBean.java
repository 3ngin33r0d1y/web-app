package manageBean;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ServerDaoLocal;
import entities.SmartPhone;
import entities.User;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Moussaab
 */


@ManagedBean(name="phonebean")
@RequestScoped
public class phoneBean {
	public User user=new User();
	public List<SmartPhone> list;

	@EJB
	private ServerDaoLocal local;

	
	public List<User> findallUsers() {
		return local.findAllUsers();
	}
	public void load() {
		findSmartPhoneByUser(this.user.getIdUser());
	}


	public void findSmartPhoneByUser(@PathParam(value = "im") Long code) {
		this.list = local.findSmartPhoneByUser(code); 
		
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	public List<SmartPhone> getList() {
		return list;
	}

	public void setList(List<SmartPhone> list) {
		this.list = list;
	}

}
