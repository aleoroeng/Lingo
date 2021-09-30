export class Noun {
  constructor(value: string) {
    this.value = value;
  }

  public getValue(): string {
    return this.value;
  }
  private value: string;
}
