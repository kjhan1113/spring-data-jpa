# Spring Data JPA

- spring boot 3.2.9
- postgres 16

## Query Creation from Method Name
| Keyword          | Sample                                                            | JPQL snippet                                                            |
|------------------|-------------------------------------------------------------------|-------------------------------------------------------------------------|
| And              | findByLastNameAndFirstName                                        | ... where x.lastname = ?1 and x.firstname = ?2                          |
| Or               | findByLastNameOrFirstName                                         | ... where x.lastname = ?1 or x.firstname = ?2                           |
| Is, Equals       | findByFirstName,<br/>findByFirstNameIs,<br/>findByFirstNameEquals | ... where x.firstname =? 1                                              |
| Between          | findByStartDateBetween                                            | ... where x.startDate between ?1 and ?2                                 |
| LessThan         | findByAgeLessThan                                                 | ... where x.age < ?1                                                    |
| LessThanEqual    | findByAgeLessThanEqual                                            | ... where x.age <= ?1                                                   |
| GreaterThan      | findByAgeGreaterThan                                              | ... where x.age > ?1                                                    |
| GreaterThanEqual | findByAgeGreaterThanEqual                                         | ... where x.age >= ?1                                                   |
| After            | findByStartDateAfter                                              | ... where x.startDate > ?1                                              |
| Before           | findByStartDateBefore                                             | ... where x.startDate < ?1                                              |
| NotLike          | findByFirstNameNotLike                                            | ... where x.firstname not like ?1                                       |
| StartingWith     | findByFirstNameStartingWith                                       | ... where x.firstname like ?1<br/>(Parameters are bound by adding %)    |
| EndingWith       | findByFirstNameEndingWith                                         | ... where x.firstname list ?1<br/>(Parameters are bound by adding %)    |
| Containing       | findByFirstNameContaining                                         | ... where x.firstname like ?1<br/>(Parameter bindings are wrapped in %) |
| OrderBy          | findByAgeOrderByLastNameDesc                                      | ... where x.age = ?1 order by x.lastname desc                           |
| Not              | findByLastNameNot                                                 | ... where x.lastname <> ?1                                              |
| In               | findByAgeIn(Collection<Age>ages)                                  | ... where x.age in ?1                                                   |
| NotIn            | findByAgeNotIn(Collection<Age> ages)                              | ... where x.age not in ?1                                               |
| True             | findByActiveTrue()                                                | ... where x.active = true                                               |
| False            | findByActiveFalse()                                               | ... where x.active = false                                              |
| IgnoreCase       | findByFirstNameIgnoreCase                                         | ... where UPPER(x.firstname) = UPPER(?1)                                |
