
# ULTRA COIN 🪙

An easy-to-use Fintech with a focus on personal accounts! 

## Get started

We use Java 11.

## API Documentation.

#### Return person by id.

```http
  GET /person/{id}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Required**. Person id. |

#### Return person by tax id.

```http
  GET person/taxid/{taxid}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `taxId` | `String` | **Required**. Tax id number. |

#### Return address by id number.

```http
  GET /person/address/{id}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Required**. Address id. |

#### Return address by person Id.

```http
  GET /person/address/{personId}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `personId` | `Long` | **Required**. Address id. |

#### Return account by id.

```http
  GET account/{id}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Required**. Account id. |
#### Return account by account number.

```http
  GET account/getByNumber/{accountNumber}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `id` | `int` | **Required**. Number account. |

#### Return transaction by id.

```http
  GET /transaction/{id}
```

| Parameter   | Type       | Description                        |
| :---------- | :--------- | :---------------------------------- |
| `id` | `Long` | **Required**. Transaction id. |


## Stack 


**Back-end:** Java, SpringBoot, MySQL


## Created by

- [Dan Pinheiro](https://github.com/ddsp-pinheiro)      





                                                                                                                                                           
#### For more documentation

[Class diagram](https://drive.google.com/file/d/1WT1T3viu3__jsikGlKdZSKiraaKA266D/view?usp=sharing)

