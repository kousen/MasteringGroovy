package gjdk

println 'Groundhog sees shadow --> 6 more weeks of Winter'
Calendar c = Calendar.instance

c.set(2015, Calendar.FEBRUARY, 2)
Date groundHogDay = c.time

c.set(2015, Calendar.MARCH, 20)
Date firstDayOfSpring = c.time

def days = firstDayOfSpring - groundHogDay
assert days == (firstDayOfSpring..groundHogDay).size() - 1

println """
There are ${(int)(days/7)} weeks and ${days % 7} days between GroundHog Day 
and the first day of Spring (March 20), so Spring 
comes early if the groundhog sees his shadow.
"""