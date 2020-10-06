import { TestBed } from '@angular/core/testing';

import { GameChoiceService } from './game-choice.service';

describe('GameChoiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GameChoiceService = TestBed.get(GameChoiceService);
    expect(service).toBeTruthy();
  });
});
