import { PropertiesStoreModule } from './properties-store.module';

describe('PropertiesStoreModule', () => {
  let propertiesStoreModule: PropertiesStoreModule;

  beforeEach(() => {
    propertiesStoreModule = new PropertiesStoreModule();
  });

  it('should create an instance', () => {
    expect(propertiesStoreModule).toBeTruthy();
  });
});
