package cse213.user;

import java.io.Serializable;

public class Supplier extends User implements TaxPayer, Serializable {


    @Override
    public Float calculateAndGetTaxPayable(){
        Float val = 0.0f;
        //
        return val;
    }
}
