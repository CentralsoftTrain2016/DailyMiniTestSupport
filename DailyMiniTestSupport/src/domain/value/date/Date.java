package domain.value.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Era;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;
import java.time.temporal.ValueRange;

import domain.value.Value;

public class Date extends Value{

	private LocalDate date; // 日付


	public Date(String date) {
		super();
		this.date = LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
	}


	public Date(LocalDate date){
		this.date = date;
	}

	public LocalDate getValue(){
		return date;
	}

	public String toString(){

		return date.format(DateTimeFormatter.ISO_DATE);
	}

	public boolean isSupported(TemporalField field) {
		return date.isSupported(field);
	}

	public boolean isSupported(TemporalUnit unit) {
		return date.isSupported(unit);
	}

	public ValueRange range(TemporalField field) {
		return date.range(field);
	}

	public int get(TemporalField field) {
		return date.get(field);
	}

	public long getLong(TemporalField field) {
		return date.getLong(field);
	}

	public IsoChronology getChronology() {
		return date.getChronology();
	}

	public Era getEra() {
		return date.getEra();
	}

	public int getYear() {
		return date.getYear();
	}

	public int getMonthValue() {
		return date.getMonthValue();
	}

	public Month getMonth() {
		return date.getMonth();
	}

	public int getDayOfMonth() {
		return date.getDayOfMonth();
	}

	public int getDayOfYear() {
		return date.getDayOfYear();
	}

	public DayOfWeek getDayOfWeek() {
		return date.getDayOfWeek();
	}

	public boolean isLeapYear() {
		return date.isLeapYear();
	}

	public int lengthOfMonth() {
		return date.lengthOfMonth();
	}

	public int lengthOfYear() {
		return date.lengthOfYear();
	}

	public LocalDate with(TemporalAdjuster adjuster) {
		return date.with(adjuster);
	}

	public LocalDate with(TemporalField field, long newValue) {
		return date.with(field, newValue);
	}

	public LocalDate withYear(int year) {
		return date.withYear(year);
	}

	public LocalDate withMonth(int month) {
		return date.withMonth(month);
	}

	public LocalDate withDayOfMonth(int dayOfMonth) {
		return date.withDayOfMonth(dayOfMonth);
	}

	public LocalDate withDayOfYear(int dayOfYear) {
		return date.withDayOfYear(dayOfYear);
	}

	public LocalDate plus(TemporalAmount amountToAdd) {
		return date.plus(amountToAdd);
	}

	public LocalDate plus(long amountToAdd, TemporalUnit unit) {
		return date.plus(amountToAdd, unit);
	}

	public LocalDate plusYears(long yearsToAdd) {
		return date.plusYears(yearsToAdd);
	}

	public LocalDate plusMonths(long monthsToAdd) {
		return date.plusMonths(monthsToAdd);
	}

	public LocalDate plusWeeks(long weeksToAdd) {
		return date.plusWeeks(weeksToAdd);
	}

	public LocalDate plusDays(long daysToAdd) {
		return date.plusDays(daysToAdd);
	}

	public LocalDate minus(TemporalAmount amountToSubtract) {
		return date.minus(amountToSubtract);
	}

	public LocalDate minus(long amountToSubtract, TemporalUnit unit) {
		return date.minus(amountToSubtract, unit);
	}

	public LocalDate minusYears(long yearsToSubtract) {
		return date.minusYears(yearsToSubtract);
	}

	public LocalDate minusMonths(long monthsToSubtract) {
		return date.minusMonths(monthsToSubtract);
	}

	public LocalDate minusWeeks(long weeksToSubtract) {
		return date.minusWeeks(weeksToSubtract);
	}

	public LocalDate minusDays(long daysToSubtract) {
		return date.minusDays(daysToSubtract);
	}

	public <R> R query(TemporalQuery<R> query) {
		return date.query(query);
	}

	public Temporal adjustInto(Temporal temporal) {
		return date.adjustInto(temporal);
	}

	public long until(Temporal endExclusive, TemporalUnit unit) {
		return date.until(endExclusive, unit);
	}

	public Period until(ChronoLocalDate endDateExclusive) {
		return date.until(endDateExclusive);
	}

	public String format(DateTimeFormatter formatter) {
		return date.format(formatter);
	}

	public LocalDateTime atTime(LocalTime time) {
		return date.atTime(time);
	}

	public LocalDateTime atTime(int hour, int minute) {
		return date.atTime(hour, minute);
	}

	public LocalDateTime atTime(int hour, int minute, int second) {
		return date.atTime(hour, minute, second);
	}

	public LocalDateTime atTime(int hour, int minute, int second, int nanoOfSecond) {
		return date.atTime(hour, minute, second, nanoOfSecond);
	}

	public OffsetDateTime atTime(OffsetTime time) {
		return date.atTime(time);
	}

	public LocalDateTime atStartOfDay() {
		return date.atStartOfDay();
	}

	public ZonedDateTime atStartOfDay(ZoneId zone) {
		return date.atStartOfDay(zone);
	}

	public long toEpochDay() {
		return date.toEpochDay();
	}

	public int compareTo(ChronoLocalDate other) {
		return date.compareTo(other);
	}

	public boolean isAfter(ChronoLocalDate other) {
		return date.isAfter(other);
	}

	public boolean isBefore(ChronoLocalDate other) {
		return date.isBefore(other);
	}

	public boolean isEqual(ChronoLocalDate other) {
		return date.isEqual(other);
	}

	public boolean equals(Object obj) {
		return date.equals(obj);
	}

	public int hashCode() {
		return date.hashCode();
	}

}
