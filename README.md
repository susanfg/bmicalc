![example workflow](https://github.com/jmhorcas/bmicalc/actions/workflows/maven.yml/badge.svg)

# BMI calculator
A biomedical calculator for the body mass index (BMI) and other parameters.

## Test cases

These test cases were written on paper before implementing the tests.

- Test cases for the method bmi():

We are going to try with valid and invalid values for both parameters.
    - weight < 0, it has to throw an error
    - weight > 800, it has to throw an error
    - weight = 0, it has to throw an error
    - height < 0, it has to throw an error
    - height > 3, it has to throw an error
    - height = 0, it has to throw an error
    - weight = 65, height = 1.6, it has to return 25.390625 
    - weight = 70, height = 1.85, it has to return 20.4528853

- Test cases for the method category():

Here we want to try with bmi values that are in the bounds of each category, values that are not in the bounds, and invalid values.

    - bmi < 0, it has to throw an error
    - bmi = 0, it has to throw an error
    - bmi = 15.87, it has to return UNDERWEIGHT
    - bmi = 18.49, it has to return UNDERWEIGHT
    - bmi = 20.64, it has to return NORMAL
    - bmi = 18.5, it has to return NORMAL
    - bmi = 24.9, it has to return NORMAL
    - bmi = 27.34, it has to return OVERWEIGHT
    - bmi = 25, it has to return OVERWEIGHT
    - bmi = 29.9, it has to return OVERWEIGHT
    - Bmi = 45.98, it has to return OBESE
    - bmi = 30.0, it has to return OBESE

- Test cases for method abdominalObesity():

We are going to try with valid and invalid values of both parameters, checking also that the method does not discriminate between lower case and upper case. We are also testing what happens when the waistCircumference for each gender takes the limit value (80 for females, 90 for males).

    - waistCircumference = -1, gender = 'M', it has to throw an error
    - waistCircumference = -1, gender = 'F', it has to throw an error
    - waistCircumference = 0, gender = 'M', it has to throw an error
    - waistCircumference = 0, gender = 'F', it has to throw an error
    - waistCircumference > 1000, gender = 'M', it has to throw an error
    - waistCircumference > 1000, gender = 'F', it has to throw an error
    - waistCircumference = 170, gender = 'g', it has to throw an error
    - waistCircumference = 170, gender = 'm', it has to return TRUE
    - waistCircumference = 60, gender = 'f', it has to return FALSE
    - waistCircumference = 90, gender = 'F', it has to return TRUE
    - waistCircumference = 80, gender = 'F', it has to return FALSE
    - waistCircumference = 70, gender = 'F', it has to return FALSE
    - waistCircumference = 100, gender = 'M', it has to return TRUE
    - waistCircumference = 90, gender = 'M', it has to return FALSE
    - waistCircumference = 76, gender = 'M', it has to return FALSE

![Use Cases Diagram](https://github.com/susanfg/bmicalc/blob/main/Doc/CasosDeUso.png)

## Use case specification

Name: Determine Abdominal Obesity

Primary Actor: User
 
Main Goal: The user wants to determine if he/she has abdominal obesity using the health calculator system.

Scope: Health calculator’s system

Level: User Goal 

Stakeholders and interests: 
- User: Determine if he/she has abdominal obesity and obtain a reliable, easy-to-understand result.
- Healthcare Company: determine correctly if the user has abdominal obesity or not. 
- Developers: Their interests include creating an efficient, reliable, easy-to-maintain, and easy-to-update system.

Precondition: The user knows his/her waist circumference and gender.

Minimal Guarantee: The system will display the result to the user in a clear format, indicating whether they have abdominal obesity or not. In case of an error, the system will communicate it on the screen.

Success Guarantee: The user receives valuable information that can help improve their health and well-being.

Trigger: The user selects the option to determine if they have abdominal obesity.

Main Success Scenario:
1. User enters waist circumference and gender.
2. System confirms the data is valid.
3. System compares the user information with the reference values in order to determine if they have abdominal obesity.
4. The system displays whether the user has abdominal obesity or not.
5. The system shows recommendations for maintaining a healthy weight or reducing the risk of health problems (depending on the result), and the user receives this information on the screen.

Alternate scenarios:
- 1.a The user enters an invalid weight value.
- 1.b System shows an error message.
- 1.c Back to step 1

Or

- 1.a The user enters an invalid gender value.
- 1.b System shows an error message.
- 1.c Back to step 1

## User stories and Scenarios

**User stories**

Feature: 

As a [role]
I want [sw feature]
So that [benefit]

**Scenario:**
 
Given [initial condition]
When [events occur]
Then [expected outcome]

- Feature: Calculate BMI

As a user

I want to calculate my BMI 

So that I will know if I have a healthy weight or not.


**Scenario 1: The weight is invalid**

Given that I want to calculate my BMI

When I input a weight equal to -70 and that I select the option BMI

Then the calculator shows an error message saying that the weight is invalid


**Scenario 2: The height is invalid**

Given that I want to calculate my BMI

When I input a height equal to -1.7 and that I select the option BMI

Then the calculator shows an error message saying that the weight is invalid


**Scenario 3: Both values are correct**

Given that I want to calculate my BMI

When I enter weight = 60 and I enter height = 1.68 and select the option BMI

Then the calculator gives me the value BMI = 21.258503401


- Feature: Determine category

As a user

I want to determine my category according to my BMI.

So that I will know if I am in a healthy category or not.


**Scenario 1: Valid category**

Given that I want to determine my category

When I input my weight <w> and I input my height <h>

Then the system computes the BMI and returns the category <c>

EXAMPLES

  w  |  h   | c           |

 70  | 1.95 | UNDERWEIGHT |

 65  | 1.68 | NORMAL      | 

 94.6| 1.87 | OVERWEIGHT  |

100.2| 1.77 | OBESE       |


The BMI value is computed by the system before determining the category. So any error produced when calculating the BMI value will be treated in that scenario. That is why we do not take into account error scenarios in this user story.

- Feature: Determine abdominal obesity

As a user

I want to determine if I have abdominal obesity according to my waist circumference and gender

So that I will know whether I must change my diet and exercise.


**Scenario 1: Male determines abdominal obesity**

Given that I want to determine if I have abdominal obesity

When I input my waist circumference of <w> cm and gender "M" into the abdominal obesity determination feature

Then the system returns a message saying: <r>.

EXAMPLES

 w  |  r                                |

 95 | you have abdominal obesity        |

 75 | you do not have abdominal obesity |


**Scenario 2: Female determines abdominal obesity**

Given that I want to determine if I have abdominal obesity

When I input my waist circumference of <w> cm and gender "F" into the abdominal obesity determination feature

Then the system returns a message saying: <r>.

EXAMPLES

 w  |  r                                |

 95 | you have abdominal obesity        |

 75 | you do not have abdominal obesity |


**Scenario 3: Wrong waist circumference value**

Given that I want to determine if I have abdominal obesity

When I input a waist circumference of -5 cm and gender "F" into the abdominal obesity determination feature

Then the system returns an error message saying "Invalid waist circumference value"

**Scenario 4: Wrong gender**

Given that I want to determine if I have abdominal obesity

When I enter my waist circumference of 80 cm and gender value 's'

Then the system returns an error message saying "Invalid gender character"

## User Graphic Interface

Graphic interface prototype:

![Prototype](https://github.com/susanfg/bmicalc/blob/main/Doc/UserInterface.png)

Graphic interface implementation:

![Prototype](https://github.com/susanfg/bmicalc/blob/main/Doc/UserInterfaceImplementation.png)



