export function dateRange(month, year) {
	var startDate = new Date(year, month-1, 1);
	var endDate = new Date(year, month, 0);
	return {
		start: startDate,
		end: endDate
	}
}

export function dateFormatter(date) {
	var month = date.getMonth()+1;
	var day = date.getDate();
	return `${date.getFullYear()}-${(month <= 9)? "0"+month: month}-${(day <= 9)? "0"+day: day}`;
}

export function currencyFormatter(value) {
	if(value < 0) {
		return `-$${Math.abs(value)}`;
	}else { 
		return `$${value}`; 
	}
}

