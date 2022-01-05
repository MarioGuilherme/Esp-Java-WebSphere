package br.com.loja.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

import br.com.loja.model.daos.ClientDAO;
import br.com.loja.model.daos.PhoneDAO;
import br.com.loja.model.entities.Client;
import br.com.loja.model.entities.Phone;

@ManagedBean(name = "PhoneMB")
@SessionScoped
public class PhoneMB {
    private String selectedOption;
    private DataModel<Phone> listPhones;

    private Phone phone = new Phone();
    private PhoneDAO phoneDAO = new PhoneDAO();

    private String option;
    private List<String> options;

    @PostConstruct
	public void init() {
    	options = new ArrayList<>();
		ClientDAO clientDAO = new ClientDAO();
		List<Client> clients = clientDAO.SelectAll();
        for (int i = 0; i < clients.size() ; i++) {
        	options.add(clients.get(i).getId_client() + " - " + clients.get(i).getName());
        }
    }

    public String getSelectedOption() {
        return selectedOption;
    }

    public void setSelectedOption(String selectedOption) {
        this.selectedOption = selectedOption;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getOption() {
        options = new ArrayList<>();
		ClientDAO clientDAO = new ClientDAO();
		List<Client> clients = clientDAO.SelectAll();
        for (int i = 0; i < clients.size() ; i++) {
        	options.add(clients.get(i).getId_client() + " - " + clients.get(i).getName());
        }
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

	public void SelectPhone() {
		this.phone = listPhones.getRowData();
		ClientDAO clientDAO = new ClientDAO();
		Client client = new Client();
		client.setId_client(phone.getId_client());
		client = clientDAO.SelectById(client);
		this.option = client.getId_client() + " - " + client.getName();
	}

	public String FormatPhone(String phone) {
		return "+" + phone.substring(0, 2) + " (" + phone.substring(2, 4) + ") " + phone.substring(4, 9) + "-" + phone.substring(9, 13);
	}

	public void NewReg() {
		this.phone = new Phone();
		this.option = null;
	}
	public String DeletePhone() {
		String response = "responses/generics/erro";
		try {
			if(phoneDAO.Delete(phone)) {
				response = "responses/phone/telefone-deletado";
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		return response;
	}

	public String UpdatePhone() {
		String response = "responses/generics/erro";
		if(option == "" || phone.getPhone() == "") {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
	    		phone.setId_client(Integer.parseInt(option.split(" - ")[0]));
	    		if(phoneDAO.Update(phone)) {
					response = "responses/phone/telefone-editado";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return response;
	}

    public DataModel<Phone> getListPhones() {
		List<Phone> list = phoneDAO.SelectAll();
		listPhones = new ListDataModel<Phone> (list);
		return listPhones;
	}

    public String NewPhone() {
    	String response = "responses/generics/erro";
		if(option == "" || phone.getPhone() == "") {
			System.out.println("Campos vazios");
			response = "responses/generics/campos-vazios";
		}else {
			try {
	    		phone.setId_client(Integer.parseInt(option.split(" - ")[0]));
				if(phoneDAO.Insert(phone)) {
					response = "responses/phone/telefone-cadastrado";
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return response;
    }
}