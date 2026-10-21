# Object Oriented Programming Assessment

This directory contains the code for the Object Oriented Programming portion of the technical assessment.
This project utilises maven, which must be installed / available to run the subsequent showcase tests.

To initialise the project, download dependencies and verify it builds correctly run the following:

```shell
mvn clean install
```

TODO: Complete README

## Rationale
Vague titles, such as "Architect" or "Accountant" can be used to describe a larger range of job titles.
For example:
Solutions Architect, Security Architect, and even Building Architects can all be acceptably described as an Architect.

Discrete job titles, like "Software Engineer", whilst still encompassing a wide range of job roles, contains a modifier
to narrow the scope of roles which can be attributed to it.
For example:
A Java Engineer, Go Engineer or Front End Engineer are all examples of a Software Engineer.
A Civil Engineer, Automotive Engineer or Aerospace Engineer are not examples of a Software Engineer but can be loosely 
coupled by them both being Engineering based professions.

### Role Weighting
A quality score is used to determine the correlation between a given title and the predefined list of normalised tites.
Vague, or encompassing job descriptions will be automatically be awarded a qaulity score of `1` as their jobs can 
easily be normalised.
For discrete or specific roles, more than one key word needs to be matched to achieve an equally strong correlation. 
This means that each word is weighted with a quality score of `0.4`
The weighting is given in such way that widely normalisable titles can always compete over specific job titles.

E.g. Software Engineering Architect will achieve a quality score of `1` against `Architect` and `0.8` against 
`Software Engineer`. The result will be `Architect`.

In the case of no matching normalised job title, the original title will be returned.
In the case of empty, blank or no input, an exception will be thrown.