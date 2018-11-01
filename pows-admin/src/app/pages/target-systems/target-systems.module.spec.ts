import { TargetSystemsModule } from './target-systems.module';

describe('TargetSystemsModule', () => {
  let targetSystemsModule: TargetSystemsModule;

  beforeEach(() => {
    targetSystemsModule = new TargetSystemsModule();
  });

  it('should create an instance', () => {
    expect(targetSystemsModule).toBeTruthy();
  });
});
