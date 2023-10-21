package common;

import model.FormatModel;

public class Algorithm {

    Validation validation = new Validation();
    FormatModel model=new FormatModel();
    
    public void checkPhone() {
        System.out.print("Phone number: ");
        String phoneNumber = validation.checkInputPhone();
        model.setPhone(phoneNumber);
    }

    public void checkMail() {
        System.out.print("Email: ");
        String email = validation.checkInputEmail();
        model.setEmail(email);
    }

    public void checkDate() {
        System.out.print("Date: ");
        String date = validation.checkInputDate();
        model.setDate(date);
    }
}
