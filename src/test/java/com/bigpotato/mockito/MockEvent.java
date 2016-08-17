package com.bigpotato.mockito;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

/**
 * Created by hjy on 16/8/14.
 */
@RunWith(MockitoJUnitRunner.class)
public class MockEvent {
    @Mock
    private Event e;

    @Test
    public void testMockEvent() {
        when(e.getStartTime()).thenReturn(10);
        System.out.println(e.getStartTime());
        doReturn(20).when(e).getStartTime();
        System.out.println(e.getStartTime());
    }
}
