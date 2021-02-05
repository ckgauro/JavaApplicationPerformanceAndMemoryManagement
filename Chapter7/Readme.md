### Escaping References

Iterable<Customer>



### Map.copyOf(records);
It throws following exception and prevents from accidentally modified.
> records.getCustomers().clear();

```
Exception in thread "main" java.lang.UnsupportedOperationException
```

## Lecture 32

> Modify in Customer Class
```
public Customer(Customer c){
        this.name=c.getName();
    }
```    
----------
### CustomerRecords Now it will return copy Customer
```
  public Customer find(String name){

        return new Customer((records.get(name)));
      //  return records.get(name);
    }
        

```

## Lecture 33  using interface to create immutable objects

