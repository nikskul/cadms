export const currencyFormatter = new Intl.NumberFormat("ru-RU", {
  style: "currency",
  currency: "RUB",
});

export function dateWithPostfix(number: number) {
  let right = number % 10;
  let left = Math.trunc((number / 10) % 10);

  if (left === 1) {
    return number + " лет";
  }

  if (right === 1) {
    return number + " год";
  }

  if (right > 4 || right === 0) {
    return number + " лет";
  }

  return number + " года";
}
