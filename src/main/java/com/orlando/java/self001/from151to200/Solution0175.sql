# Write an SQL query to report the first name, last name, city, and state of each person in the Person table. If the address of a personId is not present in the Address table, report null instead.
#
# Return the result table in any order.
#
#
select firstName, lastName, city, state
 from Person p left join address a on p.personId = a.personId;