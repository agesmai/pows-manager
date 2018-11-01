import { PowsUserModule } from './pows-user.module';

describe('PowsUserModule', () => {
  let powsUserModule: PowsUserModule;

  beforeEach(() => {
    powsUserModule = new PowsUserModule();
  });

  it('should create an instance', () => {
    expect(powsUserModule).toBeTruthy();
  });
});
